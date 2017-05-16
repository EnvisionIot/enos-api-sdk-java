package com.envision.eeop.api.util;

import java.lang.reflect.Type;

import com.envision.eos.event.api.expression.Filter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class EventJsonParser {

	private static final Gson gson = new GsonBuilder().registerTypeAdapter(Filter.class, new FilterDeserializer())
			.create();

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

	public static class FilterDeserializer implements JsonSerializer<Filter>, JsonDeserializer<Filter> {

		@Override
		public Filter deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException {
			try {
				String type = ((JsonObject) json).get("type").getAsString();

				Class<?> klass = Class.forName(type);

				return context.deserialize(((JsonObject) json).get("object"), klass);

			} catch (ClassNotFoundException e) {

			}

			return null;
		}

		@Override
		public JsonElement serialize(Filter src, Type typeOfSrc, JsonSerializationContext context) {
			JsonElement json = context.serialize(src, src.getClass());
			JsonObject j = new JsonObject();
			j.add("type", new JsonPrimitive(src.getClass().getName()));
			j.add("object", json);

			return j;
		}

	}

}
