package dda.spring.webflux.myWebFlux.handlers;

import dda.spring.webflux.myWebFlux.domain.Message;
import dda.spring.webflux.myWebFlux.dto.Greeting;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Component
public class InfoHandler {

    public Mono<ServerResponse> info(ServerRequest request) {

        var start = request
                .queryParam("start")
                .map(Long::valueOf)
                .orElse(0L);

        var count = request
                .queryParam("count")
                .map(Long::valueOf)
                .orElse(3L);

        Flux<Message> map = Flux.just(
                "Hello, reactive",
                "I love flux!",
                "Get me code",
                "LetsCode good channel")
                .skip(start)
                .take(count)
                .map(Message::new);

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(map, Message.class);
    }
}
