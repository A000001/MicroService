package com.liaohao.common.utils;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.util.LinkedHashMap;

public class BeanUitls {

    /**
     * 缓存BeanCopier避免重复创建，但是不能一直创建，对内存不友好
     */
    private static LinkedHashMap<String, BeanCopier> keyCache = new LinkedHashMap();

    public static void copy(Object source, Object target) {
        BeanCopier beanCopier = getBeanCopier(source.getClass(), target.getClass(), false);
        beanCopier.copy(source, target, null);
    }

    public static void copy(Object source, Object target, Converter converter) {
        BeanCopier beanCopier = getBeanCopier(source.getClass(), target.getClass(), true);
        beanCopier.copy(source, target, converter);
    }

    /**
     * 创建并缓存BeanCopier，限定keyCache大小为Integer.MAX_VALUE，到达最大移除第一个（是否优化为使用少的有限移除）
     * @param source
     * @param target
     * @param useConverter
     * @return
     */
    private static BeanCopier getBeanCopier(Object source, Object target, boolean useConverter) {
        String key = generateKey(source.getClass(), target.getClass());
        if (keyCache.containsKey(key)) {
            return keyCache.get(key);
        }
        BeanCopier beanCopier = BeanCopier.create(source.getClass(), target.getClass(), useConverter);
        if (keyCache.size() > Integer.MAX_VALUE) {
            keyCache.remove(0);
        }
        keyCache.put(key, beanCopier);
        return beanCopier;
    }

    private static String generateKey(Class<?> aClass, Class<?> aClass1) {
        return aClass.toString() + aClass1.toString();
    }

}
