package com.cch.resource.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.TEXT_PLAIN)
public class CSVMessageBodyWriter implements MessageBodyWriter<Object> {

	@Override
	public long getSize(Object object, Class<?> genericType, Type rawType,
			Annotation[] annotations, MediaType mediaType) {
		return -1;
	}

	@Override
	public boolean isWriteable(Class<?> genericType, Type rawType,
			Annotation[] annotations, MediaType mediaType) {
		if (genericType.isAnnotationPresent(CSVType.class)) {
			return true;
		}
		return false;
	}

	@Override
	public void writeTo(Object object, Class<?> genericType, Type rawType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> responseHeaderMap,
			OutputStream outputstream) throws IOException,
			WebApplicationException {
		PrintWriter writer = null;
		String csv = null;

		try {
			csv = convertToCSV(genericType, object);
			writer = new PrintWriter(outputstream);
			writer.print(csv);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(e);
		} finally {
			writer.close();
		}

	}

	private String convertToCSV(Class<?> classType, Object object)
			throws IllegalArgumentException, IllegalAccessException {
		StringBuffer buffer = null;
		Field[] fields = null;
		boolean isFirst = true;

		buffer = new StringBuffer();
		fields = classType.getDeclaredFields();
		for (Field f : fields) {
			f.setAccessible(true);
			if (isFirst) {
				buffer.append(f.getName()).append("=").append(f.get(object));
			} else {
				buffer.append(",").append(f.getName()).append("=")
						.append(f.get(object));
			}
		}
		return buffer.toString();
	}

}
