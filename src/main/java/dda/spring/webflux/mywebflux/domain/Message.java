package dda.spring.webflux.mywebflux.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Message {
    @Id
    private Long id;
    private String data;

    public Message(String data) {
        this.data = data;
    }
}
