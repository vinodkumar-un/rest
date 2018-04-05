package com.cch.resource.client;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

@Provider
@Consumes(MediaType.TEXT_PLAIN)
public class CSVMessageBodyReader implements MessageBodyReader<Object> {
	private final static String DELIMETER = ",";

	@Override
	public boolean isReadable(Class<?> genericType, Type rawType,
			Annotation[] annotations, MediaType mediaType) {
		if (genericType.isAnnotationPresent(CSVType.class)) {
			return true;
		}
		return false;
	}

	@Override
	public Object readFrom(Class<Object> genericType, Type rawType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> requestHeaderMap,
			InputStream inputStream) throws IOException,
			WebApplicationException {
		Object obj = null;
		String data = null;
		Map<String, String> dataMap = null;
		try {
			data = extractData(inputStream);
			dataMap = convertToMap(data);
			obj = bind(genericType, dataMap);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(e);
		}

		return obj;
	}

	private String extractData(InputStream inputStream) throws IOException {
		int c = 0;
		StringBuffer buffer = null;
		BufferedInputStream bis = null;

		try {
			buffer = new StringBuffer();
			bis = new BufferedInputStream(inputStream);
			while ((c = bis.read()) != -1) {
				buffer.append((char) c);
			}
		} finally {
			bis.close();
			inputStream.close();
		}
		return buffer.toString();
	}

	private Map<String, String> convertToMap(String data) {
		Map<String, String> dataMap = null;
		String token = null;
		String[] splits = null;
		StringTokenizer tokenizer = null;

		tokenizer = new StringTokenizer(data, DELIMETER);
		dataMap = new HashMap<String, String>();
		while (tokenizer.hasMoreTokens()) {
			token = tokenizer.nextToken();
			splits = token.split("=");
			dataMap.put(splits[0], splits[1]);
		}
		return dataMap;
	}

	private Object bind(Class<Object> classType, Map<String, String> dataMap)
			throws InstantiationException, IllegalAccessException,
			NoSuchFieldException, SecurityException, IllegalArgumentException,
			InvocationTargetException {
		Field field = null;
		Object obj = null;
		String attrVal = null;

		obj = classType.newInstance();
		for (String attrNm : dataMap.keySet()) {
			attrVal = dataMap.get(attrNm);
			setValue(obj, classType, attrNm, attrVal);
		}

		return obj;
	}

	private void setValue(Object obj, Class<Object> classType, String attrNm,
			String attrVal) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method[] methods = null;

		methods = classType.getDeclaredMethods();
		for (Method method : methods) {
			if (method.getName().equalsIgnoreCase("set" + attrNm)) {
				method.invoke(obj, attrVal);
				break;
			}
		}
	}

}
