package com.liaohao.common.utils;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

public class MyBeanUitls {

    public static void copy(Object source, Object target){
        BeanCopier beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
        beanCopier.copy(source, target, null);
    }

    public static void copy(Object source, Object target, Converter converter){
        BeanCopier beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
        beanCopier.copy(source, target, converter);
    }
}
