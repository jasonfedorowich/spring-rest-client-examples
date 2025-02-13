package guru.springframework.springrestclientexamples.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ExpirationDate implements Serializable {
    private String date;
    private Integer timezone_type;
    private String timezone;

}
