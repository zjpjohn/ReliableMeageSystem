package com.zjp.consumer.core;

import com.zjp.consumer.domain.N1Record;
import com.zjp.consumer.domain.N2Record;
import com.zjp.consumer.service.N1RecordService;
import com.zjp.consumer.service.N2RecordService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
 * Date: 2017/1/22
 * Time: 22:25
 */
public class RepeatMessageHandle {

    @Resource
    private N1RecordService n1RecordService;

    @Resource
    private N2RecordService n2RecordService;

    /**
     * 判断消息是否重复
     *
     * @param params 参数
     * @param n2     是否是n2级别
     * @return
     */
    @Transactional
    public void repeatHandle(Map<String, Object> params,
                             MessageMethodHandle methodHandle,
                             boolean n2) throws Exception {
        String data = (String) params.get("data");
        String messageId = (String) params.get("messageId");
        Long timeStamp = Long.valueOf((String) params.get("timeStamp"));
        String topic = (String) params.get("topic");
        StringEvent event = new StringEvent(messageId, topic, data);
        //n1级别的消息
        if (!n2) {
            N1Record n1Record = n1RecordService.selectN1Record(messageId);
            //消息不重复
            if (n1Record == null) {
                n1Record = new N1Record();
                n1Record.setMessageId(messageId);
                n1Record.setTimeStamp(timeStamp);
                //添加消息记录
                n1RecordService.addN1Record(n1Record);
                //业务处理
                methodHandle.invokeMethod(event);
            }
        } else {
            //n2级别消息
            N2Record n2Record = n2RecordService.selectN2Record(params);
            //业务唯一标识
            String businessMark = (String) params.get("businessMark");
            //没有消息记录
            if (n2Record == null) {
                n2Record = new N2Record();
                n2Record.setBusinessMark(businessMark);
                n2Record.setTimeStamp(timeStamp);
                n2Record.setDestName(topic);
                //添加消息记录
                n2RecordService.addN2Record(n2Record);
                methodHandle.invokeMethod(event);
            } else if (timeStamp > n2Record.getTimeStamp()) {
                n2Record.setTimeStamp(timeStamp);
                //更新消息记录
                n2RecordService.updateN2Record(n2Record);
                methodHandle.invokeMethod(event);
            }
        }
    }

}
