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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Client {
    private final RestTemplate restTemplate;
    private final HttpHeaders headers;
    private String url = "http://94.198.50.185:7081/api/users";

    @Autowired
    public Client(RestTemplate restTemplate, HttpHeaders headers) {
        this.restTemplate = restTemplate;
        this.headers = headers;
        this.headers.set("Cookie",
                String.join(";", restTemplate.headForHeaders(url).get("Set-Cookie")));
    }

    public String getAnswer() {
        return addUser().getBody() + updateUser().getBody() + deleteUser().getBody();
    }

    // Получение всех пользователей -  …/api/users ( GET )
    private List<User> getAllUsers() {
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange(url, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<User>>() { });
        System.out.println(responseEntity.getHeaders());
        return responseEntity.getBody();
    }

    // Добавление пользователя - …/api/users ( POST )
    private ResponseEntity<String> addUser() {
        User user = new User(3L, "James", "Brown", (byte) 5);
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        return restTemplate.postForEntity(url, entity, String.class);
    }

    // Изменение пользователя - …/api/users ( PUT )
    private ResponseEntity<String> updateUser() {
        User user = new User(3L, "Thomas", "Shelby", (byte) 5);
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        return restTemplate.exchange(url, HttpMethod.PUT, entity, String.class, 3);
    }

    // Удаление пользователя - …/api/users /{id} ( DELETE )
    private ResponseEntity<String> deleteUser() {
        Map<String, Long> uriVariables = new HashMap<>() {{
            put("id", 3L);
        }};
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        return restTemplate.exchange(url + "/{id}", HttpMethod.DELETE, entity, String.class, uriVariables);
    }
}



















