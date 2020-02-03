package org.eclipse.classes;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class DateDeserializer implements JsonDeserializer<Date> {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public Date deserialize(JsonElement dateJson, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		// TODO Auto-generated method stub
		try {
			return dateFormat.parse(dateJson.getAsString());
		} catch (ParseException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}

}
