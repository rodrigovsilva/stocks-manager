package com.rvfs.challenge.stocksmanager.util;

import java.io.IOException;
import java.util.Calendar;

import org.joda.time.format.ISODateTimeFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CalendarSerializer extends JsonSerializer<Calendar> {
	@Override
	public void serialize(Calendar value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		jgen.writeString(ISODateTimeFormat.dateTime().print(value.getTimeInMillis()));
	}
}