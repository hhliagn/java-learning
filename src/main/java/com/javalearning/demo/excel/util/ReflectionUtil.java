package com.javalearning.demo.excel.util;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;

/**
 * 反射工具类
 * @author Easley
 * @since 1.0.1
 * @date 2019/8/29
 */
public final class ReflectionUtil {
    private static final Log LOGGER = LogFactory.getLog(ReflectionUtil.class);

    private ReflectionUtil() {
        throw new IllegalStateException("Error getting instance of Utility class.");
    }

    /**
     * 直接读取对象属性值,无视 private/protected修饰符,不经过 getter方法.
     * @author Easley
     * @param obj 目标 obj
     * @param fieldName 属性名
     * @return 属性值
     * @since 1.0.1
     * @date 2019/8/29
     */
    @SuppressWarnings("all")
    public static Object getValueByFieldName(Object obj, String fieldName)
            throws IllegalAccessException {
        Field field = getDeclaredField(obj, fieldName);
        Object value = null;
        if (field != null) {
            if (field.isAccessible()) {
                value = field.get(obj);
            } else {
                field.setAccessible(true);
                value = field.get(obj);
                field.setAccessible(false);
            }
        }
        return value;
    }

    /**
     * 直接设置对象属性值,无视 private/protected修饰符,不经过 setter方法.
     * @author Easley
     * @param obj 目标 obj
     * @param fieldName 属性名
     * @param value 要设置的属性值
     * @since 1.0.1
     * @date 2019/8/29
     */
    public static void setValueByFieldName(Object obj, String fieldName, Object value)
            throws NoSuchFieldException, IllegalAccessException {
        Field field = obj.getClass().getDeclaredField(fieldName);
        if (field.isAccessible()) {
            field.set(obj, value);
        } else {
            field.setAccessible(true);
            field.set(obj, value);
            field.setAccessible( false );
        }
    }

    /**
     * 直接调用对象方法,无视 private/protected修饰符.
     * @author Easley
     * @param object 目标 obj
     * @param methodName 要调用的方法名
     * @param parameterTypes 参数类型列表
     * @param parameters 参数列表
     * @return 调用结果
     * @since 1.0.1
     * @date 2019/8/29
     */
    @SuppressWarnings("all")
    public static Object invokeMethod(final Object object, final String methodName, final Class<?>[] parameterTypes, final Object[] parameters)
        throws InvocationTargetException {
        Method method = getDeclaredMethod(object, methodName, parameterTypes);
        if (method == null) {
            throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + object + "]");
        }
        method.setAccessible(true);
        try {
            return method.invoke(object, parameters);
        } catch (IllegalAccessException e) {}
        return null;
    }

    /**
     * 循环向上转型, 根据 fieldName获取 DeclaredField.
     * @author Easley
     * @param object 目标 obj
     * @param fieldName 字段名称
     * @return Field
     * @since 1.0.1
     * @date 2019/8/29
     */
    @SuppressWarnings("all")
    public static Field getDeclaredField(final Object object, final String fieldName) {
        for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                return superClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {}
        }
        return null;
    }

    /**
     * 根据方法名获取 DeclaredMethod
     * @author Easley
     * @param object 目标 obj
     * @param methodName 方法名
     * @param parameterTypes 参数类型列表
     * @return Method
     * @since 1.0.1
     * @date 2019/8/29
     */
    @SuppressWarnings("all")
    private static Method getDeclaredMethod(Object object, String methodName, Class<?>[] parameterTypes) {
        for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                return superClass.getDeclaredMethod(methodName, parameterTypes);
            } catch (NoSuchMethodException e) {}
        }
        return null;
    }

    /**
     * 通过反射,获得Class定义中声明的父类的泛型参数的类型. eg. public UserDao extends HibernateDao<User>
     * @author Easley
     * @param clazz Xxx.class
     * @return 返回第 1个继承类型，无继承则返回 Object.class
     * @since 1.0.1
     * @date 2019/8/29
     */
    @SuppressWarnings( "unchecked" )
    public static <T> Class<T> getSuperClassGenericType(final Class clazz) {
        return getSuperClassGenericType(clazz, 0);
    }

    /**
     * 通过反射,获得Class定义中声明的父类的泛型参数的类型. eg. public UserDao extends HibernateDao<User>
     * @author Easley
     * @param clazz Xxx.class
     * @param index 指定返回第 index+1个继承类型
     * @return 返回第 index+1个继承类型，无继承则返回 Object.class
     * @since 1.0.1
     * @date 2019/8/29
     */
    @SuppressWarnings("all")
    public static Class getSuperClassGenericType(final Class clazz, final int index) {
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            LOGGER.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if ((index >= params.length) || (index < 0)) {
            LOGGER.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: " + params.length);
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            LOGGER.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
            return Object.class;
        }
        return (Class) params[index];
    }

    /**
     * 将反射时的 checked exception转换为 unchecked exception.
     * @author Easley
     * @param e checkedException
     * @return unchecked exception
     * @since 1.0.1
     * @date 2019/8/29
     */
    public static IllegalArgumentException convertToUncheckedException(Exception e) {
        if ((e instanceof IllegalAccessException)
                || (e instanceof IllegalArgumentException)
                || (e instanceof NoSuchMethodException)) {
            return new IllegalArgumentException("Reflection Exception.", e);
        } else {
            return new IllegalArgumentException(e);
        }
    }

    /**
     * 通过Getter方法获取属性值
     * @param o
     * @param fieldName
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws IntrospectionException
     */
    public static Object getValueByGetter(Object o, String fieldName) throws InvocationTargetException, IllegalAccessException, IntrospectionException {
        Field declaredField = getDeclaredField(o, fieldName);
        declaredField.setAccessible(true);
        PropertyDescriptor pd = new PropertyDescriptor(declaredField.getName(), o.getClass());
        Method readMethod = pd.getReadMethod();
        return readMethod.invoke(o);
    }
}
