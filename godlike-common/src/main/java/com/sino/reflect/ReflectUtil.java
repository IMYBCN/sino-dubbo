package com.sino.reflect;

import com.sino.util.StringUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * Created by admin on 2015/5/22.
 */
public class ReflectUtil {

    /**
     * 获取一个类的所有字段（public、private和proteced，但是不包括父类的字段）
     *
     * @param model
     * @return 当前类的所有字段
     */
    public static Field[] getFields(Object model) {
        Field[] fields = model.getClass().getDeclaredFields();
        return fields;
    }

    /**
     * 获取一个字段的名称
     *
     * @param field
     * @return 当前字段的名称
     */
    public static String getFieldName(Field field) {
        String name = field.getName();
        return name;
    }

    /**
     * 获取一个字段的类型
     *
     * @param field
     * @return 当前字段的类型
     */
    public static Type getFieldType(Field field) {
        Type type = field.getGenericType();
        return type;
    }

    /**
     * 获取一个字段的get方法
     *
     * @param model 包含当前字段的类
     * @param field 字段
     * @return 当前字段的get方法
     * @throws NoSuchMethodException
     */
    public static Method getFieldGetMethod(Object model, Field field) throws NoSuchMethodException {
        String fieldName = ReflectUtil.getFieldName(field);
        fieldName = StringUtil.firstToUpper(fieldName);
        Method method = model.getClass().getMethod("get" + fieldName);
        return method;
    }

    /**
     * 获取某个类的某个字段值
     *
     * @param model 包含当前字段的类
     * @param field 字段
     * @return 当前指定字段值
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static Object getFieldValue(Object model, Field field) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = ReflectUtil.getFieldGetMethod(model, field);
        Object object = method.invoke(model);
        return object;
    }


}
