package dda.spring.webflux.mywebflux.handlers;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class IndexHandler {
    public Mono<ServerResponse> index(ServerRequest request) {
        String name = request
                .queryParam("name")
                .orElse("NoName");

        return ServerResponse
                .ok()
                .render("index", Map.of("user", name));
    }
}
