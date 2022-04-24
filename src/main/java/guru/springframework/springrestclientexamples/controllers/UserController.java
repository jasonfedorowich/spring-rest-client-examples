package guru.springframework.springrestclientexamples.controllers;

import guru.springframework.springrestclientexamples.domain.Data;
import guru.springframework.springrestclientexamples.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    private final ApiService apiService;

    public UserController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping("/users")
    public Data getUsers(Integer limit){
        return apiService.getUsers(limit);
    }
}
