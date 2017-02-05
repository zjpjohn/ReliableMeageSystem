package com.zjp.consumer.core;

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
 * Time: 23:13
 */

public class StringEvent implements Event<String> {

    private String messageId;

    private String topic;

    private String data;

    public StringEvent() {
    }

    public StringEvent(String messageId, String topic, String data) {
        this.messageId = messageId;
        this.topic = topic;
        this.data = data;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setData(String data) {
        this.data = data;
    }

    /**
     * 消息Id
     *
     * @return
     */
    public String messageId() {
        return messageId;
    }

    /**
     * 消息地址
     *
     * @return
     */
    public String topic() {
        return topic;
    }

    /**
     * 消息内容
     *
     * @return
     */
    public String content() {
        return data;
    }
}
