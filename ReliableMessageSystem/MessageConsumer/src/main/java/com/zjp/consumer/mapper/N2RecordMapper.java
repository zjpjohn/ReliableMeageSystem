package com.zjp.consumer.mapper;

import com.zjp.consumer.domain.N2Record;

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
 * Module Desc:com.zjp.consumer.mapper
 * User: zjprevenge
 * Date: 2017/1/22
 * Time: 15:14
 */

public interface N2RecordMapper {

    /**
     * 根据业务标识查询N2类型的记录
     *
     * @param params 查询参数
     * @return
     */
    N2Record selectN2RecordByMark(Map<String, Object> params);

    /**
     * 根据参数查询N2类型的记录
     *
     * @param params 查询参数
     * @return
     */
    N2Record selectN2Record(Map<String, Object> params);

    /**
     * 添加N2类型的记录
     *
     * @param n2Record N2记录
     * @return
     */
    int addN2Record(N2Record n2Record);

    /**
     * 更新N2类型的记录
     *
     * @param n2Record N2类型的记录
     * @return
     */
    int updateN2Record(N2Record n2Record);
}
