package dda.spring.webflux.myWebFlux.controllers;

import dda.spring.webflux.myWebFlux.domain.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/controller")
public class MainController {
    @GetMapping
    Flux<Message> getMessage(
            @RequestParam(defaultValue = "0") Long start,
            @RequestParam(defaultValue = "3") Long count) {
        return Flux.just(
                "Hello, reactive",
                "I love flux!",
                "Get me code",
                "LetsCode good channel")
                .skip(start)
                .take(count)
                .map(Message::new);
    }
}
