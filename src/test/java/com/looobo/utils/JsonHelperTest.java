package com.looobo.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class JsonHelperTest {

    @Test
    public void testAsJsonString() throws Exception {
        Map<String, Object> result = Maps.newHashMap();
        result.put("total", 10);
        result.put("result", "hello");

        String res = JsonHelper.asJsonString(result);
        assertEquals(res, "{\"total\":10,\"result\":\"hello\"}");
    }

    @Test
    public void testToJsonMap() throws Exception {
        String jsonString = "{\"total\":10,\"result\":\"hello\"}";
        Map<String, Object> result = JsonHelper.toJsonMap(jsonString);

        assertEquals(result.get("total"), 10);
        assertEquals(result.get("result"), "hello");
    }


    @Test
    public void testConvert() throws Exception {
        String jsonString = "{\"total\":10,\"result\":\"hello\"}";
        JsonNode jsonNode = JsonHelper.convert(jsonString);

        assertEquals(jsonNode.path("total").asInt(), 10);
        assertEquals(jsonNode.path("result").textValue(), "hello");
    }
}
