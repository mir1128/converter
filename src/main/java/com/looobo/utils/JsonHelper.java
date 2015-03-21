package com.looobo.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.looobo.exception.InvalidJsonException;

public class JsonHelper {
    private final static ObjectMapper MAPPER = new ObjectMapper();

    public static String asJsonString(Map<String, Object> result) {
        try {
            return MAPPER.writeValueAsString(result);
        } catch (IOException e) {
            throw new RuntimeException("Could not convert response to json");
        }
    }

    public static Map<String, Object> toJsonMap(String jsonString) {
        try {
            return MAPPER.readValue(jsonString, new TypeReference<HashMap<String, Object>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException("Could not convert jsonString  to json:" + jsonString);
        }
    }

    public static JsonNode convert(String sourceJson) {
        try {
            return MAPPER.readValue(sourceJson, JsonNode.class);
        } catch (IOException e) {
            throw new InvalidJsonException("JSON could not be parsed: " + sourceJson, e);

        } catch (RuntimeException e) {
            throw new InvalidJsonException("JSON could not be parsed: " + sourceJson, e);
        }
    }
}

