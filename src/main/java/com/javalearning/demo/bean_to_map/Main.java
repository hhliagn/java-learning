package com.javalearning.demo.bean_to_map;

import org.apache.commons.beanutils.PropertyUtilsBean;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, Object> beanToMap(Object obj, boolean isIgnore) {
        Map<String, Object> params = new HashMap<String, Object>(0);
        try {
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj);
            for (int i = 0; i < descriptors.length; i++) {
                String name = descriptors[i].getName();
                if (!"class".equals(name)) {
                    Object value = propertyUtilsBean.getNestedProperty(obj, name);
                    if (isIgnore) {
                        if (null != value) {
                            params.put(name, value);
                        }
                    } else {
                        params.put(name, value);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }

    public static void main(String[] args) {
//        User user = new User();
        Integer a = 1;
        Map<String, Object> stringObjectMap = beanToMap(a, false);
        System.out.println(stringObjectMap);
    }
}
