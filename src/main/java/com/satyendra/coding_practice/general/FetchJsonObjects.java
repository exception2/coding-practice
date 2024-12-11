package com.satyendra.coding_practice.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Map;

public class FetchJsonObjects {
    public static void main(String[] args) throws IOException {
        FetchJsonObjects objects = new FetchJsonObjects();
        Map<String, Object> map = (Map<String, Object>)objects.getAPIResponse();
        System.out.println(map.size());
    }
    private Object getAPIResponse() throws IOException {

        URL url = new URL("http://jsonmock.hackerrank.com/api/article_users?page=1");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.addRequestProperty("Content-Type", "application/json");
        InputStream inputStream = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }

        return null;
    }


}

