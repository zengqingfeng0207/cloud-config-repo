package com.frankwork.cloud.security.demo.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target({ FIELD, METHOD })
@Constraint(validatedBy=MyConstraintValidator.class)
public @interface MyUserConstraint {

	String message() default "用户名已存在";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
