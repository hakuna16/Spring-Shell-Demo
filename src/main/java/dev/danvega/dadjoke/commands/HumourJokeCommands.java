package dev.danvega.dadjoke.commands;

import dev.danvega.dadjoke.client.DadJokeClient;
import dev.danvega.dadjoke.client.HumourJokeClient;
import dev.danvega.dadjoke.model.DadJokeResponse;
import dev.danvega.dadjoke.model.HumourJokeResponse;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class HumourJokeCommands {

  private final HumourJokeClient humourJokeClient;

  public HumourJokeCommands(HumourJokeClient humourJokeClient) {
    this.humourJokeClient = humourJokeClient;
  }

  @ShellMethod(key = "random-humour", value = "I will return a random humor joke!")
  public String getRandomDadJoke() {
    HumourJokeResponse random = humourJokeClient.random();
    return random.joke();
  }
}
