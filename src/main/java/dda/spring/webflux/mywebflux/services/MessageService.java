package dda.spring.webflux.mywebflux.services;

import dda.spring.webflux.mywebflux.domain.Message;
import dda.spring.webflux.mywebflux.repositories.MessageDAO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service

public class MessageService {
    private final MessageDAO messageDAO;

    public MessageService(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    public Flux<Message> getFluxMessage() {
        return messageDAO.findAll();
    }

    public Mono<Message> createMessage(Message message) {
        return messageDAO.save(message);
    }
}
