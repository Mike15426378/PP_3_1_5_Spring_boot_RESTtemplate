/**
 * Список URL для операций и типы запросов:
 *
 * Получение всех пользователей - …/api/users ( GET )
 * Добавление пользователя - …/api/users ( POST )
 * Изменение пользователя - …/api/users ( PUT )
 * Удаление пользователя - …/api/users /{id} ( DELETE )
 */

package com.example.pp_3_1_5_spring_boot_resttemplate.rest.client;

import com.example.pp_3_1_5_spring_boot_resttemplate.rest.model.User;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

public class Client {
    private static final String baseUrl = "http://94.198.50.185:7081/api/users";
    private static RestTemplate restTemplate = new RestTemplate();
    private static HttpHeaders headers = new HttpHeaders();
    private static HttpStatus statusCode;

    public static String start() {
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Cookie", String.join(";", restTemplate.headForHeaders(baseUrl).get("Set-Cookie")));
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        getListUserByExchangeMethod(requestEntity);

        User user = new User(3L,"James", "Brown", (byte) 1);
        HttpEntity<Object> requestEntityAdd = new HttpEntity<>(user, headers);

        User  userRename = new User(3L, "Thomas", "Shelby", (byte) 1);
        HttpEntity<Object> requestEntityUpdate = new HttpEntity<>(userRename, headers);

        return "Ответ: " + addUserByExchangeMethod(requestEntityAdd) + updateUserByExchangeMethod(requestEntityUpdate) + deleteUserByExchangeMethod(requestEntity);
    }

    private static String deleteUserByExchangeMethod(HttpEntity<Object> requestEntity) {
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl + "/3",
                HttpMethod.DELETE,
                requestEntity,
                String.class);
        statusCode = responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);
        return responseEntity.getBody();
    }

    private static String updateUserByExchangeMethod(HttpEntity<Object> requestEntity) {
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl,
                HttpMethod.PUT,
                requestEntity,
                String.class);
        statusCode = responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);
        return responseEntity.getBody();
    }

    private static String addUserByExchangeMethod(HttpEntity<Object> requestEntity) {
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl,
                HttpMethod.POST,
                requestEntity,
                String.class);
        statusCode = responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);
        return responseEntity.getBody();
    }

    private static void getListUserByExchangeMethod(HttpEntity<Object> requestEntity) {
        ResponseEntity<List> responseEntity = restTemplate.exchange(baseUrl,
                HttpMethod.GET,
                requestEntity,
                List.class);
        statusCode = responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);
        List user = responseEntity.getBody();
        System.out.println("response body - " + user);
    }
}



















