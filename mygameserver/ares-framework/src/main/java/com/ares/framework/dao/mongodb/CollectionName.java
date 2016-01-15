package com.ares.framework.dao.mongodb;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface CollectionName {
	String value() default "";
}
