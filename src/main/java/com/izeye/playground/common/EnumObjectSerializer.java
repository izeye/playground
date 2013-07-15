package com.izeye.playground.common;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class EnumObjectSerializer extends JsonSerializer<Enum<?>> {

	@Override
	public void serialize(Enum<?> value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		jgen.writeStartObject();
		Field[] declaredFields = value.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			String fieldName = field.getName();
			if (Modifier.isStatic(field.getModifiers())) {
				continue;
			}
			try {
				field.setAccessible(true);

				jgen.writeFieldName(fieldName);
				jgen.writeObject(field.get(value));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		jgen.writeEndObject();
	}

}
