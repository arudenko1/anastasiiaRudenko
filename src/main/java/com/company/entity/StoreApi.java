package com.company.entity;

import okhttp3.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class StoreApi {
    private static RequestBody requestBody;
    private static Request request;
    private static OkHttpClient client;
    private static Response response;

    public static void getInventory() throws IOException {

        String url = "https://petstore.swagger.io/v2/store/inventory";
        request = new Request.Builder()
                .url(url)
                .build();
        client = new OkHttpClient();
        Call call = client.newCall(request);
        response = call.execute();
        System.out.println(response.code());
    }

    public static void postOrderForPet() throws IOException {
        {
            String body = "{\n" +
                    "  \"id\": 3,\n" +
                    "  \"petId\": 2,\n" +
                    "  \"quantity\": 1,\n" +
                    "  \"shipDate\": \"2021-10-10T11:15:50.018+0000\",\n" +
                    "  \"status\": \"placed\",\n" +
                    "  \"complete\": true\n" +
                    "}\n";
            requestBody = RequestBody.create(body.getBytes(StandardCharsets.UTF_8));
            request = new Request.Builder()
                    .header("Content-Type", "application/json")
                    .post(requestBody)
                    .url("https://petstore.swagger.io/v2/store/order")
                    .build();
            client = new OkHttpClient();
            Call call = client.newCall(request);
            response = call.execute();
            System.out.println(response.code());
        }
    }

    public static String getOrderById(int orderID) throws IOException {
        String url = "https://petstore.swagger.io/v2/store/order/" + orderID;
        request = new Request.Builder()
                .header("Content-Type", "application/json")
                .url(url)
                .build();
        client = new OkHttpClient();
        Call call = client.newCall(request);
        response = call.execute();
        System.out.println(response.code());
        return response.body().string();
    }

    public static String deleteOrderById(int orderID) throws IOException {
        String url = "https://petstore.swagger.io/v2/store/order/" + orderID;
        request = new Request.Builder()
                .header("Content-Type", "application/json")
                .url(url)
                .build();
        client = new OkHttpClient();
        Call call = client.newCall(request);
        response = call.execute();
        System.out.println(response.code());
        return response.body().string();
    }
}
