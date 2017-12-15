package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("user");
        return "user/index";
    }

    @RequestMapping(value = "add")
    public String displayAddForm(Model model, @ModelAttribute User user) {
        model.addAttribute(new User());
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddForm(@ModelAttribute @Valid User user,
                      Errors errors, Model model, String verify) {
        System.out.println("abc " + verify + " " + user);

        if (errors.hasErrors()){
            model.addAttribute(user);
            return "user/add";
        }


        if (user.getPassword().equals(verify)){
            model.addAttribute(user);
            return "user/index";
        }else {model.addAttribute("verify", "Password and Veryify must match");
            return "user/add";
        }

    }
}