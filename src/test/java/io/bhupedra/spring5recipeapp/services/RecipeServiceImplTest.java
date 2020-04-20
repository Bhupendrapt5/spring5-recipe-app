package io.bhupedra.spring5recipeapp.services;

import io.bhupedra.spring5recipeapp.domain.Recipe;
import io.bhupedra.spring5recipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceImplTest {

    @Mock
    RecipeRepository recipeRepository;

    @InjectMocks
    RecipeServiceImpl recipeService;


    Recipe recipe = new Recipe();
    @BeforeEach
    public void setUp() throws Exception {

    }

    @Test
    public void getRecipes() {

//        Recipe recipe = new Recipe();

        Set<Recipe> recipeData = new HashSet<>();
        recipeData.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipeData);

        Set<Recipe> recipes = recipeService.getRecipes();

        //Testing if recipe set count is equal to actual count
        assertEquals(recipes.size(), 1);

        //verifying if recipeRepository is called only once
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    void getRecipeById() {
//        Recipe recipe = new Recipe();
        recipe.setId(1l);
        Optional<Recipe> recipeOptional = Optional.of(recipe);
        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe returnRecipe = recipeService.getRecipeById(1l);
        assertNotNull(returnRecipe);
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }
}