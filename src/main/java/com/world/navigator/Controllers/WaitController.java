package com.world.navigator.Controllers;

import com.world.navigator.Services.GameContainer;
import com.world.navigator.Services.DeliveringMessages;
import com.world.navigator.Services.GameResponse;
import com.world.navigator.Services.MessageString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WaitController {
    private GameContainer gameContainer;
    private DeliveringMessages deliveringMessages;

    @Autowired
    public WaitController(GameContainer gameContainer, DeliveringMessages deliveringMessages){
        this.gameContainer = gameContainer;
        this.deliveringMessages = deliveringMessages;
    }

    @GetMapping(
            path="/wait/new/{gameName}/{playerName}"
    )
    public String newWaitView(@PathVariable("gameName") String gameName,
                              @PathVariable("playerName") String playerName,
                              ModelMap model){
        model.put("game", new GameResponse(gameName, playerName));
        return "AdminWait";
    }
    @GetMapping(
            path="/wait/existing/{gameName}/{playerName}"
    )
    public String existingWaitView(@PathVariable("gameName") String gameName,
                                   @PathVariable("playerName") String playerName,
                                   ModelMap model){
        model.put("game", new GameResponse(gameName, playerName));
        model.put("message", new MessageString(("")));
        return "PlayerWait";
    }

    @PostMapping(
            path="/wait/new"
    )
    public String newWait(ModelMap model,GameResponse game){
        if(gameContainer.addGameWithAdmin(game.getName(), game.getPlayer())){
            return "redirect:/wait/new/" + game.getName() + "/" + game.getPlayer();
        }else{
            deliveringMessages.putMessageInMailbox("/login/new", "there is another game with this name");
            return "redirect:/login/new";
        }
    }

    @PostMapping(
            path="/wait/existing"
    )
    public String existingWait(GameResponse game) {
        String errorMessage = gameContainer.addPlayerToGame(game.getName(), game.getPlayer());

        if (errorMessage.equals("")) {
            return "redirect:/wait/existing/" + game.getName() + "/" + game.getPlayer();
        } else {
            deliveringMessages.putMessageInMailbox("/login/existing", errorMessage);
            return "redirect:/login/existing";
        }
    }
}
