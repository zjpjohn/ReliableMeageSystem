package com.zjp.consumer.config;

/**
 * ©¥©¥©¥©¥©¥©¥oooo©¥©¥©¥©¥©¥©¥
 * ¡¡¡¡¡¡©³©·¡¡¡¡¡¡©³©·
 * ¡¡¡¡©³©¿©ß©¥©¥©¥©¿©ß©·
 * ¡¡¡¡©§¡¡¡¡¡¡¡¡¡¡¡¡¡¡©§
 * ¡¡¡¡©§¡¡¡¡¡¡©¥¡¡¡¡¡¡©§
 * ¡¡¡¡©§¡¡©×©¿¡¡©»©×¡¡©§
 * ¡¡¡¡©§¡¡¡¡¡¡¡¡¡¡¡¡¡¡©§
 * ¡¡¡¡©§¡¡¡¡¡¡©ß¡¡¡¡¡¡©§
 * ¡¡¡¡©§¡¡¡¡¡¡¡¡¡¡¡¡¡¡©§
 * ¡¡¡¡©»©¥©·¡¡¡¡¡¡©³©¥©¿
 * ¡¡¡¡¡¡¡¡©§¡¡¡¡¡¡©§stay hungry stay foolish
 * ¡¡¡¡¡¡¡¡©§¡¡¡¡¡¡©§Code is far away from bug with the animal protecting
 * ¡¡¡¡¡¡¡¡©§¡¡¡¡¡¡©»©¥©¥©¥©·
 * ¡¡¡¡¡¡¡¡©§¡¡¡¡¡¡¡¡¡¡¡¡¡¡©Ç©·
 * ¡¡¡¡¡¡¡¡©§¡¡¡¡¡¡¡¡¡¡¡¡¡¡©³©¿
 * ¡¡¡¡¡¡¡¡©»©·©·©³©¥©×©·©³©¿
 * ¡¡¡¡¡¡¡¡¡¡©§©Ï©Ï¡¡©§©Ï©Ï
 * ¡¡¡¡¡¡¡¡¡¡©»©ß©¿¡¡©»©ß©¿
 * ©¥©¥©¥©¥©¥©¥ÃÈÃÈßÕ©¥©¥©¥©¥©¥©¥
 * Module Desc:com.zjp.consumer.config
 * User: zjprevenge
 * Date: 2017/1/22
 * Time: 13:50
 */

public class ConsumerConfig {

    private String brokerUrl;

    private String userName;

    private String password;

    private int poolSize;

    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }

    public String getBrokerUrl() {
        return brokerUrl;
    }

    public void setBrokerUrl(String brokerUrl) {
        this.brokerUrl = brokerUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
