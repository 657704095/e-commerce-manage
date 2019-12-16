package com.example.emodeldao.annotation_validator;

import com.example.emodeldao.annotation_validator.impl.MyIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Administrator
 */
@Target({ElementType.METHOD, ElementType.FIELD})  //注解的目标范围  方法，字段上
@Retention(RetentionPolicy.RUNTIME) //运行时
@Constraint(validatedBy = MyIdValidator.class)  //校验时执行的自定义类
public @interface MyId {

    String message() default "自定义的id验证器";

    Class<?>[] groups() default { };      //必须实现这三个方法

    Class<? extends Payload>[] payload() default { };

    int length() default 11;       //默认长度
}
