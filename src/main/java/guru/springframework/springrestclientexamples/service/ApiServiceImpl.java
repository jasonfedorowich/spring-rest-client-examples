package guru.springframework.springrestclientexamples.service;

import guru.springframework.springrestclientexamples.domain.Data;
import guru.springframework.springrestclientexamples.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.function.Consumer;

@Service
public class ApiServiceImpl implements ApiService{

    private final String url;
    private final RestTemplate restTemplate;

    public ApiServiceImpl(@Value("${api.url}") String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    @Override
    public Data getUsers(Integer limit) {
        UriComponentsBuilder componentsBuilder = UriComponentsBuilder.fromUriString(url)
                .queryParam("limit", limit);
        Data data = restTemplate.getForObject(componentsBuilder.toUriString(), Data.class);
        return data;
    }

    @Override
    public Flux<User> getUsers(Mono<Integer> limit) {
        return Flux.fromStream(
                restTemplate.getForObject(UriComponentsBuilder.fromUriString(url)
                        .queryParam("limit", limit).toUriString(), Data.class).getData().stream());

    }
}
