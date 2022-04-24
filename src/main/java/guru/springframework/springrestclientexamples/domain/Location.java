package guru.springframework.springrestclientexamples.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Location implements Serializable {
    private String street;
    private String city;
    private String state;
    private String postcode;

}
