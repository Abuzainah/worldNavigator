package com.world.navigator.Controllers;

import com.world.navigator.Services.GameContainer;
import com.world.navigator.Services.MessageString;
import com.world.navigator.Services.GameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PlayController {
    private GameContainer gameContainer;

    @Autowired
    public PlayController(GameContainer gameContainer){
        this.gameContainer = gameContainer;
    }

    @GetMapping(
            path="/play/{game}/{player}"
    )public String view(@PathVariable("game") String game,
                        @PathVariable("player") String player,
                        ModelMap model){
        model.put("game", new GameResponse(game, player));
        model.put("command", new MessageString());
        model.put("result", gameContainer.getResult(game, player));

        return "CommandPage";
    }

    @GetMapping(
            path="/quit/{game}/{player}"
    )public String quit(@PathVariable("game") String game,
                        @PathVariable("player") String player){
        gameContainer.process(game, player, "quit");
        gameContainer.removePlayer(game, player);
        return "redirect:/";
    }

    @PostMapping(
            path="/play/{game}/{player}"
    )public String accept(@PathVariable("game") String game,
                          @PathVariable("player") String player,
                          MessageString command){
        try {
            gameContainer.process(game, player, command.getValue());
        }catch(Exception e){
            gameContainer.process(game, player, "there is a bug in source code");
        }
        return "redirect:/play/"+ game + "/" + player;
    }
}
