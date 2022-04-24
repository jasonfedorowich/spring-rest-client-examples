package guru.springframework.springrestclientexamples.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Name implements Serializable {
    private String title;
    private String first;
    private String last;

}

