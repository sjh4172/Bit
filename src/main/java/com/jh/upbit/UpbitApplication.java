package com.jh.upbit;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UpbitApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpbitApplication.class, args);

        try {
            // HttpClient 생성
            HttpClient client = HttpClient.newHttpClient();

            // HTTP GET 요청 생성
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.upbit.com/v1/market/all"))
                    .GET()
                    .build();

            // 요청 실행 및 응답 받기
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 응답 본문 출력
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
