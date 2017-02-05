package com.zjp.consumer.annotations;

import com.zjp.consumer.spring.MessageConsumerConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
 * Module Desc:com.zjp.consumer.annotations
 * User: zjprevenge
 * Date: 2017/1/22
 * Time: 15:15
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MessageConsumerConfiguration.class)
public @interface EnableMessageQueue {
}
