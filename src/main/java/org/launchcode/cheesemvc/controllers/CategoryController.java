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

    // /Cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("categories",categoryDao.findAll());

        return "category/index";
    }

    @RequestMapping(value = "add")
    public String displayCategories(Model model) {
        model.addAttribute("Add Category", new Category());
        return "category/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST )
    public String add(Model model,
                      @ModelAttribute @Valid Category category, Errors errors){
        if (errors.hasErrors()){
            return "category/add";
        }
        categoryDao.save(category);
        return "redirect:";


    }

}
