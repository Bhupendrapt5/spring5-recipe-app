package io.bhupedra.spring5recipeapp.services;


import io.bhupedra.spring5recipeapp.commands.CategoryCommand;
import io.bhupedra.spring5recipeapp.converters.CategoryToCategoryCommand;
import io.bhupedra.spring5recipeapp.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryToCategoryCommand categoryToCategoryCommand;

    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               CategoryToCategoryCommand categoryToCategoryCommand) {
        this.categoryRepository = categoryRepository;
        this.categoryToCategoryCommand = categoryToCategoryCommand;
    }


    @Override
    public Set<CategoryCommand> getCategories() {


        return StreamSupport.stream(categoryRepository.findAll()
                .spliterator(), false)
                .map(categoryToCategoryCommand::convert)
                .collect(Collectors.toSet());
    }
}
