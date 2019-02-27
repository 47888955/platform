package com.yaoyong.demo.base.handler;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
/**
 *
 * @ClassName:  MyMetaObjectHandler
 * @Description:针对增删改时通用数据统一处理
 * @author: yaoyong
 * @date:   2018年12月1日 下午4:50:26
 *
 * @Copyright: 2018 yaoyong Inc. All rights reserved.
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

	@Override
	public void insertFill(MetaObject metaObject) {
		// 避免使用metaObject.setValue()
		this.setFieldValByName("operator", "Jerry", metaObject);
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		this.setFieldValByName("operator", "Tom", metaObject);
	}
}