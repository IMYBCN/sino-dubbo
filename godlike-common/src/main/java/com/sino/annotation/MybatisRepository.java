package com.sino.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by pierce-deng on 2015/8/24.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface MybatisRepository {
    String value() default "";
}
