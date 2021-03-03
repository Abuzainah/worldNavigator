package com.world.navigator.Controllers;

import com.world.navigator.Services.GameContainer;
import com.world.navigator.Services.GameResponse;
import com.world.navigator.Services.MessageString;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class StartController {
    private GameContainer gameContainer;

    public StartController(GameContainer gameContainer){
        this.gameContainer = gameContainer;
    }

    @GetMapping(
            path="/start/admin/{gameName}/{playerName}"
    )
    public String newAdminStart(@PathVariable("gameName") String gameName,
                                @PathVariable("playerName") String playerName){
        gameContainer.startGame(gameName);
        return "redirect:/play/" + gameName + "/" + playerName + "/";
    }

    @GetMapping(
            path="/start/player/{gameName}/{playerName}"
    )
    public String newPlayerStart(@PathVariable("gameName") String gameName,
                                 @PathVariable("playerName") String playerName,
                                 ModelMap model){
        if(gameContainer.didThisGameStart(gameName)) return "redirect:/play/" + gameName + "/" + playerName + "/";
        model.put("game", new GameResponse(gameName, playerName));
        model.put("message", new MessageString("wait until the admin start the game"));
        return "PlayerWait";
    }

}
