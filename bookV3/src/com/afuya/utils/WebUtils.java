package com.afuya.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/10 9:18 下午
 */
public class WebUtils {
    public static <T> T copyParamToBean(Map m, T bean) {
        try {
            BeanUtils.populate(bean, m);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
