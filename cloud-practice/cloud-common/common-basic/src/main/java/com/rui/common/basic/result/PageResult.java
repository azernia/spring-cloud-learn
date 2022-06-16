package com.rui.common.basic.result;

import lombok.Data;

import java.io.Serializable;

/**
 * description:
 * date: 2022/6/15 14:53
 *
 * @author rui
 */
@Data
public class PageResult<T> implements Serializable {

    // private String code;
    //
    // private Data data;
    //
    // private String msg;
    //
    // public static <T> PageResult<T> success(IPage<T> page) {
    //     PageResult<T> result = new PageResult<>();
    //     result.setCode(ResultCode.SUCCESS.getCode());
    //
    //     Data data = new Data<T>();
    //     data.setList(page.getRecords());
    //     data.setTotal(page.getTotal());
    //
    //     result.setData(data);
    //     result.setMsg(ResultCode.SUCCESS.getMsg());
    //     return result;
    // }
    //
    // @lombok.Data
    // public static class Data<T> {
    //
    //     private List<T> list;
    //
    //     private long total;
    //
    // }

}
