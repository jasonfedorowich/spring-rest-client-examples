package guru.springframework.springrestclientexamples.controllers;

import guru.springframework.springrestclientexamples.domain.Data;
import guru.springframework.springrestclientexamples.domain.LimitRequest;
import guru.springframework.springrestclientexamples.domain.User;
import guru.springframework.springrestclientexamples.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class UserController {

    private final ApiService apiService;

    public UserController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping("/users")
    public Data getUsers(@RequestBody LimitRequest limit){
        return apiService.getUsers(limit.getLimit());
    }

    @PostMapping("/users-reactive")
    public Flux<User> getUsersFlux(@RequestBody LimitRequest limit){
        return apiService.getUsers(Mono.just(limit.getLimit()));
    }
}
