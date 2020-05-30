package at.schwandter.codedemo.service;

import java.util.concurrent.atomic.AtomicLong;

import at.schwandter.codedemo.game.Game;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private Game game;

    @GetMapping("/currentplayer")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.valueOf(game.getCurrentPlayer());
    }


    public GameController(Game game) {
        this.game = game;
    }
}