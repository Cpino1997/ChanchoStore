package cl.pinolabs.chanchostore.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String login(){
        return "login";
    }

    @PostMapping
    public String verifiar(){
        boolean verifiar = false;
        if(verifiar != false){
            return "index";
        } else{
        return "login";
        }
    }
}
