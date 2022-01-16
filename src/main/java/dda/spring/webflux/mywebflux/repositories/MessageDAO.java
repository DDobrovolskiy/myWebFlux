package dda.spring.webflux.mywebflux.repositories;

import dda.spring.webflux.mywebflux.domain.Message;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MessageDAO extends ReactiveCrudRepository<Message, Long> {
}
