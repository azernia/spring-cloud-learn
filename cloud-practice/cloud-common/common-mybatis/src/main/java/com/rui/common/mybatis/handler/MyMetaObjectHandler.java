package com.rui.common.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * description: 字段自动填充
 * date: 2022/6/16 14:11
 *
 * @author rui
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 新增填充创建时间
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "create_time", LocalDateTime::now, LocalDateTime.class);
        this.strictUpdateFill(metaObject, "update_time", LocalDateTime::now, LocalDateTime.class);
    }

    /**
     * 更新填充更新时间
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "update_time", LocalDateTime::now, LocalDateTime.class);
    }

}
