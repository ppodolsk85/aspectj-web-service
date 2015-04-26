package com.agh.toik.webservice.aspectj;

import java.util.Collection;

import com.agh.toik.webservice.annotations.List;
import com.agh.toik.webservice.entities.IEntity;

public aspect EntityAspect {
	private boolean inited = false;
	
	pointcut listAnnotationMethod(List listAnnotation) : execution(@List * *()) && @annotation(listAnnotation);
	
	pointcut crudAnnotations() : call(@List * *(..)) || call(@Create * *(..)) || call(@Delete * *(..));
		
	Collection<IEntity> around(List listAnnotation) : listAnnotationMethod(listAnnotation) {
		return null;
	}
	
	before() : crudAnnotations() {
		System.out.println("LOGGER>> CRUD Annotations");
		if(!inited) {
			System.out.println("LOGGER>> Not initialized yet");
			System.out.println("LOGGER>> Setting up");
			
			
			
			inited = true;
		}
	}
}
