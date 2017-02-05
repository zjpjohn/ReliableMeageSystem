package com.zjp.producer.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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
 * Module Desc:com.zjp.producer.utils
 * User: zjprevenge
 * Date: 2017/1/23
 * Time: 20:26
 */

public class MessageUtils {

    //随机数生成器
    private static Random random = new Random();

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMssHHmmssSSS");

    /**
     * 生成消息id
     *
     * @param date
     * @return
     */
    public static String createMessageId(Date date) {
        String format = dateFormat.format(date);
        String mark = Long.toHexString(random.nextLong());
        return format.concat(mark);
    }
}
