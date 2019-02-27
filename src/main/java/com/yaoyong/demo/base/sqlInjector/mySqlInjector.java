package com.yaoyong.demo.base.sqlInjector;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;
import com.yaoyong.demo.base.sqlInjector.methods.LogicDeleteById;

public class mySqlInjector extends AbstractSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList() {
        return Stream.of(
            new LogicDeleteById()
        ).collect(toList());
    }
}