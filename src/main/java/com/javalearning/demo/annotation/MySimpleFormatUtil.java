package com.javalearning.demo.annotation;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class MySimpleFormatUtil {

    public static String format(Object object, boolean ignore) {

        try {

            Class clz = object.getClass();
            StringBuilder stringBuilder = new StringBuilder();
            for (Field field : clz.getDeclaredFields()) {

                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }

                MyLabel myLabel = field.getDeclaredAnnotation(MyLabel.class);
                Object value = field.get(object);

                if (ignore){
                    if (myLabel == null && value == null) continue;
                }

                String name = myLabel != null ? myLabel.value() : field.getName();

                if (value != null && field.getType() == Date.class){
                    value = formatDate(value, myLabel);
                }

                stringBuilder.append(name).append(":").append(value).append("\n");
            }

            return stringBuilder.toString();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return "";
    }

    private static Object formatDate(Object value, MyLabel myLabel) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(myLabel.datePattern());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(myLabel.timeZone()));
        return simpleDateFormat.format(value);
    }
}
