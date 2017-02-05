package com.zjp.producer.core;

import com.google.common.base.Preconditions;
import com.zjp.producer.domain.QMessage;
import com.zjp.producer.service.QMessageService;
import com.zjp.producer.tx.MessageTransactionSynchronizationAdapter;
import com.zjp.producer.utils.MessageHolder;
import com.zjp.producer.utils.MessageUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * ━━━━━━oooo━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃stay hungry stay foolish
 * 　　　　┃　　　┃Code is far away from bug with the animal protecting
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━萌萌哒━━━━━━
 * Module Desc:com.zjp.consumer.core
 * User: zjprevenge
 * Date: 2017/1/23
 * Time: 19:23
 */
public class MessageProducer implements InitializingBean {

    private static final Logger log = LoggerFactory.getLogger(MessageProducer.class);

    @Resource
    private TransactionMessageProducer transactionMessageProducer;

    @Resource
    private QMessageService qMessageService;

    //消息目的地
    private String destName;
    //是否开启事务
    private boolean transaction;
    //是否持久化消息
    private boolean persistent;
    //是否是n2级别的消息
    private boolean n2;

    public TransactionMessageProducer getTransactionMessageProducer() {
        return transactionMessageProducer;
    }

    public void setTransactionMessageProducer(TransactionMessageProducer transactionMessageProducer) {
        this.transactionMessageProducer = transactionMessageProducer;
    }

    public QMessageService getqMessageService() {
        return qMessageService;
    }

    public void setqMessageService(QMessageService qMessageService) {
        this.qMessageService = qMessageService;
    }

    public String getDestName() {
        return destName;
    }

    public void setDestName(String destName) {
        this.destName = destName;
    }

    public boolean isTransaction() {
        return transaction;
    }

    public void setTransaction(boolean transaction) {
        this.transaction = transaction;
    }

    public boolean isPersistent() {
        return persistent;
    }

    public void setPersistent(boolean persistent) {
        this.persistent = persistent;
    }

    public boolean isN2() {
        return n2;
    }

    public void setN2(boolean n2) {
        this.n2 = n2;
    }

    /**
     * 发送消息
     *
     * @param data
     */
    public void sendMessage(Map<String, String> data) {
        Preconditions.checkArgument(data != null && data.size() != 0, "message must not be empty...");
        transactionSynchronize();
        QMessage message = convertMessage(data);
        int result = qMessageService.addQMessage(message);
        if (result != 0) {
            MessageHolder.set(message.getMessageId());
        }
    }

    /**
     * 消息转换
     *
     * @param data
     * @return
     */
    private QMessage convertMessage(Map<String, String> data) {
        QMessage qMessage = new QMessage();
        //时间戳
        Date date = new Date();
        //生成消息id
        String messageId = MessageUtils.createMessageId(date);
        qMessage.setMessageId(messageId);
        qMessage.setMessageContent(data.get("message"));
        qMessage.setDestination(destName);
        qMessage.setTimeStamp(date.getTime());
        qMessage.setN2(n2 ? 1 : 0);
        qMessage.setStatus(0);
        qMessage.setRetry(0);
        qMessage.setPersistent(persistent ? 1 : 0);
        qMessage.setTransaction(transaction ? 1 : 0);
        //如果是n2级别的消息
        if (n2) {
            //businessMark不允许为空
            Preconditions.checkArgument(StringUtils.isNotBlank(data.get("businessMark")),
                    "This queueName:" + destName + "is n2,businessMark must not be empty...");
            qMessage.setBusinessMark(data.get("businessMark"));
        }
        return qMessage;
    }

    /**
     * 添加事务同步
     */
    private void transactionSynchronize() {
        MessageTransactionSynchronizationAdapter synchronizationAdapter = new MessageTransactionSynchronizationAdapter();
        synchronizationAdapter.setqMessageService(qMessageService);
        synchronizationAdapter.setTransactionMessageProducer(transactionMessageProducer);
        TransactionSynchronizationManager.registerSynchronization(synchronizationAdapter);
    }

    public void afterPropertiesSet() throws Exception {
        //消息队列名称不允许以ack. or ACK.开始
        if (destName.startsWith("ack.")
                || destName.startsWith("ACK.")) {
            log.error("destName must not start with ack. or ACK.");
            throw new RuntimeException("destName must not start with ack. or ACK.");
        }
    }
}
