package io.bhupedra.spring5recipeapp.services;

import io.bhupedra.spring5recipeapp.commands.CategoryCommand;
import io.bhupedra.spring5recipeapp.converters.CategoryToCategoryCommand;
import io.bhupedra.spring5recipeapp.domain.Category;
import io.bhupedra.spring5recipeapp.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    @Mock
    CategoryRepository categoryRepository;

    CategoryToCategoryCommand categoryToCategoryCommand
            = new CategoryToCategoryCommand();

    @InjectMocks
    CategoryServiceImpl service;

    @BeforeEach
    void setUp() {

        service = new CategoryServiceImpl(categoryRepository, categoryToCategoryCommand);
    }

    @Test
    void getCategories() {

        //given
        Set<Category> categories  =new HashSet<>();

        Category category1 = new Category();
        category1.setId(1L);
        categories.add(category1);

        Category category2 = new Category();
        category2.setId(2L);
        categories.add(category2);

        //when
        when(categoryRepository.findAll()).thenReturn(categories);
        Set<CategoryCommand> commandSet = service.getCategories();

        //then
        assertEquals(2, commandSet.size());
        verify(categoryRepository, times(1)).findAll();
    }
}