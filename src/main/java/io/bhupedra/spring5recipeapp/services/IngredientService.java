package io.bhupedra.spring5recipeapp.services;

import io.bhupedra.spring5recipeapp.commands.IngredientCommand;

public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand command);

    void deleteIngredientById(Long recipeId,Long idToDelete);
}
