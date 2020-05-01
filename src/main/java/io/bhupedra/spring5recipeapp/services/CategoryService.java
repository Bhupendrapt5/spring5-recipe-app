package io.bhupedra.spring5recipeapp.services;

import io.bhupedra.spring5recipeapp.commands.CategoryCommand;

import java.util.Set;

public interface CategoryService {

    Set<CategoryCommand> getCategories();

}