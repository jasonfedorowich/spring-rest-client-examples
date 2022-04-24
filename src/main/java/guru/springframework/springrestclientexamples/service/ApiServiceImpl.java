package guru.springframework.springrestclientexamples.service;

import guru.springframework.springrestclientexamples.domain.Data;
import guru.springframework.springrestclientexamples.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService{

    private static final String URL = "http://private-anon-3251dad369-apifaketory.apiary-mock.com/api/user?limit=";

    private final RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> getUsers(Integer limit) {
        Data data = restTemplate.getForObject(URL + limit, Data.class);
        return data.getData();
    }
}
