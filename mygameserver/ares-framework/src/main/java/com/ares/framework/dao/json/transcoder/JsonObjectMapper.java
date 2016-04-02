package com.ares.framework.dao.json.transcoder;

import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.datetime.joda.DateTimeFormatterFactory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.datatype.joda.cfg.JacksonJodaDateFormat;
import com.fasterxml.jackson.datatype.joda.ser.DateTimeSerializer;

/**
 * @author wesley
 */
public class JsonObjectMapper {

	public static final ObjectMapper objectMapper = JsonObjectMapper.createInstance();

	private static ObjectMapper createInstance() {

		JodaModule jodaMode = new JodaModule();

		DateTimeFormatterFactory formatterFactory = new DateTimeFormatterFactory();
	//	formatterFactory.setIso(ISO.DATE_TIME);
	//	formatterFactory.setTimeZone(TimeZone.getDefault());
		jodaMode.addSerializer(DateTime.class, new DateTimeSerializer(
				new JacksonJodaDateFormat(formatterFactory.createDateTimeFormatter().withZoneUTC())));

		return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.configure(DeserializationFeature.WRAP_EXCEPTIONS, true)
				.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false)
				.configure(SerializationFeature.WRITE_DATES_WITH_ZONE_ID, false)
				.setSerializationInclusion(JsonInclude.Include.NON_NULL).registerModule(jodaMode);

	}

	public static ObjectMapper getInstance() {
		return JsonObjectMapper.objectMapper;
	}

}
