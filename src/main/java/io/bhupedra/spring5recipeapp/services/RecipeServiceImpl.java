package io.bhupedra.spring5recipeapp.services;

import io.bhupedra.spring5recipeapp.commands.RecipeCommand;
import io.bhupedra.spring5recipeapp.converters.RecipeCommandToRecipe;
import io.bhupedra.spring5recipeapp.converters.RecipeToRecipeCommand;
import io.bhupedra.spring5recipeapp.domain.Recipe;
import io.bhupedra.spring5recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;


    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe,
                             RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.info("im in the service");

        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().forEach(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe getRecipeById(Long id) {
        Optional<Recipe> getRecipe = recipeRepository.findById(id);
        if(!getRecipe.isPresent()){
            throw new RuntimeException("Recipe not found");
        }

        return getRecipe.get();
    }

    @Override
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detachRecipe = recipeCommandToRecipe.convert(command);

        Recipe savedRecipe = recipeRepository.save(detachRecipe);
        log.debug("Saved RecipeId: "+savedRecipe.getId());

        return recipeToRecipeCommand.convert(savedRecipe);
    }


}
