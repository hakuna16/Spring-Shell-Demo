package dev.danvega.dadjoke;

import dev.danvega.dadjoke.client.DadJokeClient;
import dev.danvega.dadjoke.client.HumourJokeClient;
import dev.danvega.dadjoke.model.HumourJokeResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  DadJokeClient dadJokeClient() {
    WebClient client =
        WebClient.builder()
            .baseUrl("https://icanhazdadjoke.com")
            .defaultHeader("Accept", "application/json")
            .build();

    HttpServiceProxyFactory factory =
        HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
    return factory.createClient(DadJokeClient.class);
  }

  @Bean
  HumourJokeClient humourJokeClient() {
    WebClient client =
        WebClient.builder()
            .baseUrl(
                "https://api.humorapi.com/jokes/random?api-key=5c5533dad39442a4bef37c1e958674b1")
            .defaultHeader("Accept", "application/json")
            .build();

    HttpServiceProxyFactory factory =
        HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
    return factory.createClient(HumourJokeClient.class);
  }
}
