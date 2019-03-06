package com.phantom.util;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonUtil {

    public static JsonObject mergeJson(JsonObject json1, JsonObject json2) {
        JsonObject json = new JsonObject();
        if (json1 != null && !json1.isJsonNull() && json1.entrySet().size() > 0) {
            for (Map.Entry<String, JsonElement> entry : json1.entrySet()) {
                json.add(entry.getKey(), entry.getValue());
            }
        }
        if (json2 != null && !json2.isJsonNull() && json2.entrySet().size() > 0) {
            for (Map.Entry<String, JsonElement> entry : json2.entrySet()) {
                json.add(entry.getKey(), entry.getValue());
            }
        }
        return json;
    }

    public static int getSafeInt(JsonObject jsonObject, String member) {
        if (jsonObject == null || jsonObject.isJsonNull() || !jsonObject.has(member)) {
            return 0;
        } else {
            return (int) jsonObject.get(member).getAsDouble();
        }
    }

    public static double getSafeDouble(JsonObject jsonObject, String member) {
        if (jsonObject == null || jsonObject.isJsonNull() || !jsonObject.has(member)) {
            return 0;
        } else {
            return jsonObject.get(member).getAsDouble();
        }
    }


    public static boolean getSafeBoolean(JsonObject jsonObject, String member) {
        return jsonObject.has(member) && jsonObject.get(member).getAsBoolean();
    }

    public static String getSafeString(JsonObject jsonObject, String key) {

        if (jsonObject == null || jsonObject.isJsonNull() || !jsonObject.has(key)) {
            return "";
        }

        return jsonObject.get(key).getAsString();

    }


    public static JsonObject getSafeJson(JsonObject jsonObject, String key) {
        if (jsonObject == null || jsonObject.isJsonNull() || !jsonObject.has(key) || !(jsonObject.get(key) instanceof JsonObject)) {
            return new JsonObject();
        }

        return jsonObject.getAsJsonObject(key);
    }

    public static <T> T deepCopy(T object, Class<T> type) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(gson.toJson(object, type), type);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
