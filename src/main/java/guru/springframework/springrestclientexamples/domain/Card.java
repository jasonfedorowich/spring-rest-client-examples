package guru.springframework.springrestclientexamples.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Card implements Serializable {

    private String type;
    private String number;
    private ExpirationDate expiration_date;
    private String iban;
    private String swift;

}
