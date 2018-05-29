package moviesApp.controller;

import moviesApp.dto.UserDto;
import moviesApp.model.CriticKeys;
import moviesApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "registerPage")
public class RegisterController {

    private UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getRegisterPage(Model model) {

        model.addAttribute("userDto", new UserDto());
        return "registerPage";
    }

    @PostMapping(params = "register")
    public String registerUser(@ModelAttribute @Valid UserDto userDto, BindingResult bindingResult, @RequestParam("key") String key, Model model) {

        if(bindingResult.hasErrors()) {
            return "registerPage";
        }

        for(CriticKeys c : CriticKeys.values()) {
            System.out.println(key);
            if (key.equals(c.toString())) {
                if(userService.create(userDto, true)) {
                    return "login";
                } else {
                    model.addAttribute("message", "Failed to create critic account.");
                    return "registerPage";
                }
            }
        }

        if(userService.create(userDto, false)) {
            return "login";
        } else {
            model.addAttribute("message", "Failed to create account.");
            return "registerPage";
        }
    }
}
