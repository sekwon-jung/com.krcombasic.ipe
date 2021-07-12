package com.krcombasic.ipe.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
// @interface 는 LoginUser 라는 이름을 가진 어노테이션이 생성되었다고 보면 된다.
}
