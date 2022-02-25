package com.example.demo.game;

import com.example.demo.form.LoginForm;
import com.example.demo.player.Player;
import com.example.demo.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class GameController {

    private final PlayerService playerService;
    @Autowired
    public GameController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("title", "Home");
        model.addAttribute("error", null);
        model.addAttribute("user", null);
        model.addAttribute("loggedIn", null);
        return "index";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("title", "Log In");
        model.addAttribute("error", null);
        model.addAttribute("user", null);
        model.addAttribute("loggedIn", null);
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(LoginForm loginForm, Model model) {
        String password = loginForm.getPassword();
        String username = loginForm.getUsername();
        if(password != null && username != null){
            model.addAttribute("title", "Home");
            model.addAttribute("error", null);
            model.addAttribute("user", null);
            model.addAttribute("loggedIn", null);
            return "index";
        }
        model.addAttribute("title", "Log In");
        model.addAttribute("error", null);
        model.addAttribute("user", null);
        model.addAttribute("loggedIn", null);
        return "login";
    }

    @GetMapping("/register")
    public String getRegister(Model model){
        model.addAttribute("title", "Register");
        model.addAttribute("error", null);
        model.addAttribute("user", null);
        model.addAttribute("loggedIn", null);
        return "register";
    }
    @PostMapping("/register")
    public String doRegister(LoginForm registerForm, Model model){
        Player newUser = new Player(registerForm.getUsername(), registerForm.getPassword());
        Boolean userSaved = playerService.addNewPlayer(newUser);
        if(userSaved){
            model.addAttribute("title", "Home");
            model.addAttribute("error", null);
            model.addAttribute("user", newUser);
            model.addAttribute("loggedIn", true);
            return "index";
        }
        model.addAttribute("title", "Register");
        model.addAttribute("error", null);
        model.addAttribute("user", null);
        model.addAttribute("loggedIn", null);
        return "register";
    }

}
