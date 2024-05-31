package com.citc.Util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class Util {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // 将字符串转换为 Map
    public static Map<String, String> stringToMap(String jsonString) {
        try {
            return objectMapper.readValue(jsonString, HashMap.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 将 Map 转换为字符串
    public static String mapToString(Map<String, String> map) {
        try {
            return objectMapper.writeValueAsString(map);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
