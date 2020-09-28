package com.capgemini.pecunia.accountservice.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Constraint(validatedBy = AadharNumberValidatior.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AadharNumber {
	String message() default "aadhar number should be of 12 digits";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
