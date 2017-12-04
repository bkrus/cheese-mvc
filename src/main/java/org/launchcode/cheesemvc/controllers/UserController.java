package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("user");
        return "user/index";
    }

    @RequestMapping(value = "add")
    public String add(Model model) {
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute User user, String verify) {
        System.out.println("abc " + verify + " " + user);
        if (user.getPassword().equals(verify)) {
            return "user/index";
        } else {
            return "redirect:add";
        }


    }
}