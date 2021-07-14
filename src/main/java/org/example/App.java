package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.json.JSONObject;

import java.util.Map;

/**
 * Hello world!
 */
public class App implements RequestHandler<Map<String, String>,  Map<String, String>> {
    @Override
    public Map<String, String> handleRequest(Map<String, String> data, Context context) {
        if (!data.containsKey("message")) {
            return Map.of("error", "Field message can not be null or empty");
        }
        StringBuilder sb = new StringBuilder(data.get("message"));
        for (int i = 1; i < sb.toString().toCharArray().length; i++) {
            sb.deleteCharAt(i);
        }
        System.out.println("Hello from my lambda function!");
        return Map.of("message", sb.toString());
    }
}
