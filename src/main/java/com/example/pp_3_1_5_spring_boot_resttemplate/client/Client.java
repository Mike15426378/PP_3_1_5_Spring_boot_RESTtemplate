/**
 * Список URL для операций и типы запросов:
 *
 * Получение всех пользователей - …/api/users ( GET )
 * Добавление пользователя - …/api/users ( POST )
 * Изменение пользователя - …/api/users ( PUT )
 * Удаление пользователя - …/api/users /{id} ( DELETE )
 */

package com.example.pp_3_1_5_spring_boot_resttemplate.client;

import com.example.pp_3_1_5_spring_boot_resttemplate.model.User;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class Client {
    static RestTemplate restTemplate = new RestTemplate();
    static String baseUrl = "http://94.198.50.185:7081/api/users";
    static HttpHeaders headers = new HttpHeaders();

    public static void main(String[] args) {
        useExchangeMethodOfRestTemplate();
    }

    private static void useExchangeMethodOfRestTemplate() {

        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        getListUserByExchangeMethod(requestEntity);

        User sysUser = new User(3L,"James", "Brown", (byte) 1);
        //requestEntity = new HttpEntity<>(sysUser, headers);

        //addUserByExchangeMethod(requestEntity);

        //updateUserByExchangeMethod(requestEntity);
        //deleteUserByExchangeMethod(requestEntity);
    }

    private static void deleteUserByExchangeMethod(HttpEntity<Object> requestEntity) {
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl + "/3",
                HttpMethod.DELETE,
                requestEntity,
                String.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);
        String user = responseEntity.getBody();
        System.out.println("response body - " + user);
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        System.out.println("response headers - " + responseHeaders);
    }

    private static void updateUserByExchangeMethod(HttpEntity<Object> requestEntity) {
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl,
                HttpMethod.PUT,
                requestEntity,
                String.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);
        String user = responseEntity.getBody();
        System.out.println("response body - " + user);
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        System.out.println("response headers - " + responseHeaders);
    }

    private static void addUserByExchangeMethod(HttpEntity<Object> requestEntity) {
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl,
                HttpMethod.POST,
                requestEntity,
                String.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);
        String user = responseEntity.getBody();
        System.out.println("response body - " + user);
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        System.out.println("response headers - " + responseHeaders);
    }

    private static void getListUserByExchangeMethod(HttpEntity<Object> requestEntity) {
        ResponseEntity<List> responseEntity = restTemplate.exchange(baseUrl,
                HttpMethod.GET,
                requestEntity,
                List.class);


        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);
        List user = responseEntity.getBody();
        System.out.println("response body - " + user);
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        System.out.println("response headers - " + responseHeaders);
    }
}



















