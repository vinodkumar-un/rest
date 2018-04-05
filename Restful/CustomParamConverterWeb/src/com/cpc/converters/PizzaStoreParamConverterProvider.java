package com.cpc.converters;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import com.cpc.dto.OrderInfo;

@Provider
public class PizzaStoreParamConverterProvider implements ParamConverterProvider {

	@Override
	public <T> ParamConverter<T> getConverter(Class<T> genericType,
			Type rawType, Annotation[] annotations) {
		System.out.println("Generic Type : " + genericType.getName());
		System.out.println("rawType : " + rawType.getClass().getName());
		System.out.println("annotations : ");
		for (Annotation annon : annotations) {
			System.out.println(annon.toString());
		}
		if (genericType.isAssignableFrom(OrderInfo.class)) {
			return (ParamConverter<T>) new OrderInfoParamConverter();
		}
		return null;
	}

}
