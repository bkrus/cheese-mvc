package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    static HashMap<String, String> cheeses = new HashMap<>();

    // /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

     @RequestMapping(value = "add", method = RequestMethod.GET)
     public String displayAddCheeseForm(Model model) {
         model.addAttribute("title", "Add Cheese");
         return "cheese/add";
     }

     @RequestMapping(value = "add", method = RequestMethod.POST)
     public String multiParamExample (@RequestParam String cheeseName, @RequestParam String cheeseDesc) {
        cheeses.put(cheeseName, cheeseDesc);
        return "redirect:";
        }
    
    @RequestMapping(value = "remove")
    public String displayRemoveCheeseForm(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");
        return "cheese/remove";
    }   

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam String removeCheese){
            cheeses.remove(removeCheese);
            return "redirect:";
        }
    }


