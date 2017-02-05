package com.zjp.producer.schedule;

import com.zjp.producer.core.TransactionMessageProducer;
import com.zjp.producer.domain.QMessage;
import com.zjp.producer.service.QMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


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
 * Module Desc:com.zjp.producer.schedule
 * User: zjprevenge
 * Date: 2017/2/5
 * Time: 17:00
 */
@Component
public class CompensateMessageSchedule {

    private static final Logger log = LoggerFactory.getLogger(CompensateMessageSchedule.class);

    @Resource
    private QMessageService qMessageService;

    @Resource
    private TransactionMessageProducer producer;

    @Scheduled(cron = "0 0/10 * * * ?")
    public void compensateJob() {
        List<QMessage> messages = null;
        try {
            messages = qMessageService.selectAllQMessage(System.currentTimeMillis());
        } catch (Exception e) {
            log.error("query messages error:{}", e);
        }
        //如果没有消息，放弃执行
        if (messages == null || messages.size() == 0) {
            return;
        }
        for (QMessage message : messages) {
            producer.sendMessage(message);
        }
    }
}
