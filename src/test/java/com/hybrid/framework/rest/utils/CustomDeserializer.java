package com.hybrid.framework.rest.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class CustomDeserializer extends JsonDeserializer<Object> {

	@Override
	public Object deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node = jp.readValueAsTree();
		if (node.asText().isEmpty() || node.asText().equalsIgnoreCase("null") || node.asText()==null || node==null) {
			return "";
		}
		if(node.isInt()) {
			return node.asInt();
		} else {
			return node.asText();
		}
	}

	@Override
	public Object getNullValue() {
		return "";
	}
}
