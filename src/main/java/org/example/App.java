package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.json.JSONObject;

import java.util.Map;

/**
 * Hello world!
 */
public class App implements RequestHandler<Map<String, String>, String> {
    @Override
    public String handleRequest(Map<String, String> data, Context context) {
        JSONObject jsonObject = new JSONObject();
        if (!data.containsKey("message")) {
            jsonObject.append("error", "Field message can not be null or empty");
            return jsonObject.toString();
        }
        StringBuilder sb = new StringBuilder(data.get("message"));
        for (int i = 1; i < sb.toString().toCharArray().length; i++) {
            sb.deleteCharAt(i);
        }
        jsonObject.put("message", sb.toString());
        System.out.println(jsonObject);
        System.out.println("Hello from my lambda function!");
        return jsonObject.toString();
    }

//    public static void main(String[] args) {
//        Map<String, String> data = new HashMap<>();
//        data.put("message", "Hello Lambda!");
//        System.out.println(new App().handleRequest(data));
//    }
//
//    public String handleRequest(Map<String, String> data) {
////        JSONObject jsonObject = new JSONObject();
////        if (!data.containsKey("message")) {
////            jsonObject.append("error", "Field message can not be null or empty");
////            return jsonObject.toString();
////        }
////        StringBuilder sb = new StringBuilder(data.get("message"));
////        for (int i = 1; i < sb.toString().toCharArray().length; i++) {
////            sb.deleteCharAt(i);
////        }
////        jsonObject.put("message", sb.toString());
////        System.out.println(jsonObject);
////        System.out.println("Hello from my lambda function!");
////        return jsonObject.toString();
//        return null;
//    }

}
