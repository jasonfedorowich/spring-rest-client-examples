package guru.springframework.springrestclientexamples.service;

import guru.springframework.springrestclientexamples.domain.Data;
import guru.springframework.springrestclientexamples.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ApiService {

    Data getUsers(Integer limit);
    Flux<User> getUsers(Mono<Integer> limit);

}
