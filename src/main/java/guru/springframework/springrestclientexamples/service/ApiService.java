package guru.springframework.springrestclientexamples.service;

import guru.springframework.springrestclientexamples.domain.Data;
import guru.springframework.springrestclientexamples.domain.User;

import java.util.List;

public interface ApiService {

    Data getUsers(Integer limit);

}
