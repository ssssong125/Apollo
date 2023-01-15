package com.b4.apollo.qna.adapter;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GsonLocalDateTimeAdapter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {

	@Override
	public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
		return new JsonPrimitive(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(src));
	}

	@Override
	public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		return LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}

}
