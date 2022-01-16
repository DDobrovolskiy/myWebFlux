package dda.spring.webflux.mywebflux.router;

import dda.spring.webflux.mywebflux.handlers.GreetingHandler;
import dda.spring.webflux.mywebflux.handlers.IndexHandler;
import dda.spring.webflux.mywebflux.handlers.InfoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class GreetingRouter {

    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
        RequestPredicate predicate =
                GET("/hello")
                        .and(accept(MediaType.APPLICATION_JSON));
        return RouterFunctions
                .route(predicate, greetingHandler::hello);

    }

    @Bean
    public RouterFunction<ServerResponse> index(IndexHandler indexHandler) {
        RequestPredicate predicate =
                GET("/");
        return RouterFunctions
                .route(predicate, indexHandler::index);

    }

    @Bean
    public RouterFunction<ServerResponse> info(InfoHandler infoHandler) {
                RequestPredicate predicate =
                GET("/info")
                        .and(accept(MediaType.APPLICATION_JSON));
        return RouterFunctions
                .route(predicate, infoHandler::info);

    }
}
