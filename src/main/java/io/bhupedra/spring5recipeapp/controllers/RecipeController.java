package io.bhupedra.spring5recipeapp.controllers;


import io.bhupedra.spring5recipeapp.commands.RecipeCommand;
import io.bhupedra.spring5recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    @RequestMapping("recipe/new")
    public String getNewRecipe(Model model){

        model.addAttribute("recipe",new RecipeCommand());

        return "recipe/recipeform";
    }

    @GetMapping
    @RequestMapping({"/recipe/{id}/update"})
    public String updateRecipe(@PathVariable  String id , Model model){
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return "recipe/recipeform";
    }


    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command) {
        if (command.getId() == null) {
            return "redirect:/";
        }
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        log.debug("Recipe " + command.getDescription() + " created with ID " + command.getId());

        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }

    @GetMapping
    @RequestMapping("/recipe/{id}/delete")
    public String deleteById(@PathVariable String id) {

        recipeService.deleteById(Long.valueOf(id));
        log.debug("Deleting  Recipe: " + id);

        return "redirect:/";
    }
}
