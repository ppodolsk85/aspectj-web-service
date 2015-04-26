package com.agh.toik.webservice.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by piotrpodolski on 26/04/15.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface List {
	public String url();
	public String method();
}
