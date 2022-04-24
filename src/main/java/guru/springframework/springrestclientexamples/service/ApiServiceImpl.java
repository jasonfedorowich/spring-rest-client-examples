package guru.springframework.springrestclientexamples.service;

import guru.springframework.springrestclientexamples.domain.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

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
}
