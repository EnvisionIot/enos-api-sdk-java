package com.envision.eeop.api.util;

import java.lang.reflect.Type;

import com.envision.eos.event.api.expression.DateExpr;
import com.envision.eos.event.api.expression.Expression;
import com.envision.eos.event.api.expression.Filter;
import com.envision.eos.event.api.expression.HourExpr;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class EventJsonParser {

	private static final Gson gson = new GsonBuilder().registerTypeAdapter(Filter.class, new FilterDeserializer())
			.registerTypeAdapter(DateExpr.class, new ExpressionDeserializer())
			.registerTypeAdapter(HourExpr.class, new ExpressionDeserializer())
			.create();

	private static final String FILTER_PREFIX = "com.envision.eos.event.api.expression.";

	private EventJsonParser() {
	}

	public static <T> T fromJson(String json, Class<T> classOfT) {
		return gson.fromJson(json, classOfT);
	}

	public static <T> T fromJson(String json, Type typeOfT) {
		return gson.fromJson(json, typeOfT);
	}

	public static String toJson(Object object) {
		return gson.toJson(object);
	}
	
	public static String toJson(Object object,Type typeOfT) {
		return gson.toJson(object,typeOfT);
	}

	public static class FilterDeserializer implements JsonSerializer<Filter>, JsonDeserializer<Filter> {

		@Override
		public Filter deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException {
			try {
				String type = ((JsonObject) json).get("type").getAsString();

				type = FILTER_PREFIX + type;

				Class<?> klass = Class.forName(type);

				return context.deserialize(((JsonObject) json), klass);

			} catch (ClassNotFoundException e) {

			}

			return null;
		}

		@Override
		public JsonElement serialize(Filter src, Type typeOfSrc, JsonSerializationContext context) {
			JsonElement json = context.serialize(src, src.getClass());
			return json;
		}

	}
	
	public static class ExpressionDeserializer implements JsonSerializer<Expression>, JsonDeserializer<Expression> {

		@Override
		public Filter deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException {
			try {
				String type = ((JsonObject) json).get("type").getAsString();
				
				type=FILTER_PREFIX+type;

				Class<?> klass = Class.forName(type);

				return context.deserialize(((JsonObject) json), klass);

			} catch (ClassNotFoundException e) {

			}

			return null;
		}

		@Override
		public JsonElement serialize(Expression src, Type typeOfSrc, JsonSerializationContext context) {
			JsonElement json = context.serialize(src, src.getClass());
			return json;
		}

	}

}
