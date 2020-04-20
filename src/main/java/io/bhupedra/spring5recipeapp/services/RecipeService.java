package io.bhupedra.spring5recipeapp.services;

import io.bhupedra.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe getRecipeById(Long id);
}
