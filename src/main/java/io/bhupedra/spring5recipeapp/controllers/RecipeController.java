package io.bhupedra.spring5recipeapp.controllers;


import io.bhupedra.spring5recipeapp.commands.RecipeCommand;
import io.bhupedra.spring5recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class RecipeController {
    RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/recipe/{id}/show"})
    public String getRecipeById(@PathVariable String id, Model model) {

        model.addAttribute("recipe", recipeService.getRecipeById(new Long(id)));

        return "recipe/show";
    }

    @RequestMapping("recipe/new")
    public String getNewRecipe(Model model){

        model.addAttribute("recipe",new RecipeCommand());
        return "recipe/recipeform";
    }

    @RequestMapping({"/recipe/{id}/update"})
    public String updateRecipe(@PathVariable  String id , Model model){
            model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return "recipe/recipeform";
    }


    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command){
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        return "redirect:/recipe/"+savedCommand.getId()+"/show";
    }
}
