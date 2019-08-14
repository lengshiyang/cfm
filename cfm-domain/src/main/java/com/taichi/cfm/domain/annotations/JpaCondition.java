package com.taichi.cfm.domain.annotations;

import com.taichi.cfm.domain.annotations.Condition.Operator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JpaCondition {
	
	String field();
	
	Operator operator();
	
}
