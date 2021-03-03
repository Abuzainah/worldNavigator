package com.world.navigator.Controllers;

import com.world.navigator.Services.DeliveringMessages;
import com.world.navigator.Services.GameResponse;
import com.world.navigator.Services.MessageString;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
    private DeliveringMessages deliveringMessages;

    public LoginController(DeliveringMessages deliveringMessages){
        this.deliveringMessages = deliveringMessages;
    }

    @GetMapping(
            path = "/login/new"
    )
    public String newLoginView(ModelMap model){
        model.put("game", new GameResponse());
        model.put("message", new MessageString(deliveringMessages.getMessageFromMailbox("/login/new")));
        return "NewGame";
    }

    @GetMapping(
            path = "/login/existing"
    )
    public String existingLoginView(ModelMap model){
        model.put("game", new GameResponse());
        model.put("message", new MessageString(deliveringMessages.getMessageFromMailbox("/login/existing")));
        return "ExistingGame";
    }


    @PostMapping(
            path = "/login/new"
    )
    public String newLogin(){

        return "redirect:/login/new";
    }

    @PostMapping(
            path = "/login/existing"
    )
    public String existingLogin(){

        return "redirect:/login/existing";
    }
}
