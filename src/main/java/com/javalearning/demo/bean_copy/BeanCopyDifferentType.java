package com.javalearning.demo.bean_copy;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author lhh
 * @date 2021/3/29
 */
public class BeanCopyDifferentType {

    public static void copyProperties(Object source, Object target, String dateFormat) throws InvocationTargetException, IllegalAccessException {
        copy(source, dateFormat, target);
    }

    public static void copyProperties(Object source, Object target) throws InvocationTargetException, IllegalAccessException {
        String dateFormat = null;
        copy(source, dateFormat, target);
    }

    public static <T> T copyProperties(Object source, Class<T> targetClass) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        String dateFormat = null;
        T target = null;
        if (source != null){
            target = targetClass.newInstance();
            copy(source, dateFormat, target);
        }
        return target;
    }

    public static <T> T copyProperties(Object source, Class<T> targetClass, String dateFormat) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        T target = null;
        if (source != null){
            target = targetClass.newInstance();
            copy(source, dateFormat, target);
        }
        return target;
    }

    public static <T> List listConverter(List list, Class<T> classT, String dateFormat) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        List<T> targetList = new ArrayList();
        if (list != null && list.size() != 0){
            Iterator var3 = list.iterator();
            while(var3.hasNext()) {
                Object object = var3.next();
                targetList.add(copyProperties(object, classT, dateFormat));
            }
        }
        return targetList;
    }

    private static void copy(Object source, String dateFormat, Object target) throws IllegalAccessException, InvocationTargetException {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");
        if (dateFormat == null) {
            dateFormat = "yyyy-MM-dd HH:mm:ss";
        }

        Class<?> aClass = source.getClass();
        PropertyDescriptor[] apds = BeanUtils.getPropertyDescriptors(aClass);
        Class<?> bClass = target.getClass();
        PropertyDescriptor[] pds = BeanUtils.getPropertyDescriptors(bClass);
        int n = pds.length;
        for (int i = 0; i < n; ++i) {
            PropertyDescriptor targetPd = pds[i];
            Method writeMethod = targetPd.getWriteMethod();
            if (writeMethod != null) {
                PropertyDescriptor sourcePd = BeanUtils.getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (sourcePd != null) {
                    Method readMethod = sourcePd.getReadMethod();
                    for (int j = 0; j < apds.length; j++) {
                        PropertyDescriptor apd = apds[j];
                        if (apd.getReadMethod().getName().equals(readMethod.getName())) {
                            // 将对象2的属性get方法转换成对象1的get方法（获得的value的类型就是对象1的该属性的类型）
                            readMethod = apd.getReadMethod();
                            continue;
                        }
                    }

                    if (readMethod != null) {
                        if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                            readMethod.setAccessible(true);
                        }

                        Object value = readMethod.invoke(source);
                        // 此处对要赋的值类型进行判断和处理
                        if (value.getClass().equals(Date.class)) {
                            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
                            value = sdf.format(value);
                        } else if (value.getClass().equals(BigDecimal.class)) {
                            BigDecimal b = (BigDecimal) value;
                            value = b.doubleValue();
                        }

                        if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                            writeMethod.setAccessible(true);
                        }

                        writeMethod.invoke(target, value);
                    }
                }
            }
        }
    }

}
