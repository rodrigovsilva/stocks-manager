package com.rvfs.challenge.stocksmanager.util.gson;

import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class CalendarAdapter implements JsonSerializer<Calendar>, JsonDeserializer<Calendar> {

	@Override
	public JsonElement serialize(Calendar src, Type typeOfSrc, JsonSerializationContext context) {
		return new JsonPrimitive(ISODateTimeFormat.dateTime().print(src.getTimeInMillis()));
	}

	@Override
	public Calendar deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		Calendar calendar = Calendar.getInstance();
		DateTime dt = new DateTime(json.getAsString());
		Date date = new Date(dt.getMillis());
		calendar.setTime(date);
		return calendar;
	}

}
