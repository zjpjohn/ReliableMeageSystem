package com.zjp.producer.core;

import com.google.common.base.Preconditions;
import com.zjp.producer.service.QMessageService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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
 * Module Desc:com.zjp.producer.core
 * User: zjprevenge
 * Date: 2017/1/23
 * Time: 19:43
 */
@Component
public class MessageHandleCallback implements MessageCallback {

    private static final Logger log = LoggerFactory.getLogger(MessageHandleCallback.class);

    @Resource
    private QMessageService qMessageService;

    /**
     * 事务消息处理成功
     *
     * @param messageId 消息id
     */
    public void onSuccess(String messageId) {
        Preconditions.checkArgument(StringUtils.isNotBlank(messageId), "messageId must not empty");
        qMessageService.deleteQMessage(messageId);
    }

    /**
     * 事务消息处理失败,进行日志记录
     *
     * @param e         异常
     * @param messageId 消息id
     */
    public void onFail(Exception e, String messageId) {
        log.error("send tx messageId:{},error:{}", messageId, e);
    }
}
