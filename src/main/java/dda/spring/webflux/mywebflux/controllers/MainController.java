package dda.spring.webflux.mywebflux.controllers;

import dda.spring.webflux.mywebflux.domain.Message;
import dda.spring.webflux.mywebflux.services.MessageService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/controller")
public class MainController {
    private final MessageService messageService;

    public MainController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    Flux<Message> getMessage(
            @RequestParam(defaultValue = "0") Long start,
            @RequestParam(defaultValue = "3") Long count) {
        return messageService.getFluxMessage();
    }

    @PostMapping
    Mono<Message> save(Message message) {
        return messageService.createMessage(message);
    }
}
