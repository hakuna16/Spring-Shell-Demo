package dev.danvega.dadjoke.client;

import dev.danvega.dadjoke.model.HumourJokeResponse;
import org.springframework.web.service.annotation.GetExchange;

public interface HumourJokeClient {

    @GetExchange("/")
    HumourJokeResponse random();
}
