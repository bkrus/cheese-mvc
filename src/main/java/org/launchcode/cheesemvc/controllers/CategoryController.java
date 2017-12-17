package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Category;
import org.launchcode.cheesemvc.models.data.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    //
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "Categories");
        model.addAttribute("Categories",categoryDao.findAll());

        return "category/index";

    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayCategories(Model model) {
        model.addAttribute("title", "Ad Categories");
        model.addAttribute(new Category());
        return "category/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST )
    public String add(@ModelAttribute @Valid Category category, Errors errors, Model model){

        if (errors.hasErrors()){
            model.addAttribute("title", "Add Name");
            return "category/add";
        }
        categoryDao.save(category);
        return "redirect:";


    }

}
