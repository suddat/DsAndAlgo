package com.ds.algo.interviewPreparation;

import java.util.Base64;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor tpe = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        for(int i = 0 ; i< 10 ; i++){
            final int taskId = i;
            tpe.execute(() -> {
                System.out.println("task Executor : " + taskId);
            });
        }

        //generate basic auth with only secret key
        /*String apiKey = "95A15C8F4014546975A453346587C2";
        String basicAuth = generateBasicAuth(apiKey);
        System.out.println(basicAuth);*/
    }
    public static String generateBasicAuth(String apiKey) {
        // Combine API key and empty password separated by a colon
        String credentials = apiKey + ":";

        // Encode credentials using Base64 encoding
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());

        // Prepend "Basic " to the encoded credentials
        return "Basic " + encodedCredentials;
    }
}
