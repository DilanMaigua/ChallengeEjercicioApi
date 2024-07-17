package com.everis.base.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class KarateUtils {

    public static String getValueFromJson(String json, String key) {
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        return jsonObject.get(key).getAsString();
    }
}
