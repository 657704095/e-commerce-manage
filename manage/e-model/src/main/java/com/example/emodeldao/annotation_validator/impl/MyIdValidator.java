package com.example.emodeldao.annotation_validator.impl;

import com.example.emodeldao.admin.Admin;
import com.example.emodeldao.annotation_validator.MyId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

/**
 * @author Administrator
 */
public class MyIdValidator implements ConstraintValidator<MyId, Object> {

    int length;

    private static Admin admin;

    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        boolean flag = false;
        //类对象，或者叫反射对象
        Class adminClass = Admin.class;

        //属性对象
        Field field = null;
        Object rest = null;
        Integer id =0;
        try {
            field = adminClass.getDeclaredField("id");
            //打开私有访问
            field.setAccessible(true);
            id = (Integer)o;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        //判断id的长度是否符合标准
        if(id.toString().length()<=length){
            flag = true;
        }else{
            flag = false;
        }

        return flag;
    }

    /**
     * 获取注解的值
     * MyId,就是注解对象
     * length()就是注解对象中的属性。
     * @param myId
     */
    public void initialize(MyId myId) {
        length= myId.length();
    }

    /**
     *
     * @param admins
     */
    public static void setAdmin(Admin admins){
        admin = admins;
    }
}
