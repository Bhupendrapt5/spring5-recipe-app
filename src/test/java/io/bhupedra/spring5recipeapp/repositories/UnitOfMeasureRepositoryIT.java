package io.bhupedra.spring5recipeapp.repositories;

import io.bhupedra.spring5recipeapp.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    public void setUp() throws Exception {

    }

    @Test
    public void findByDescription() {

        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Pinch");

        assertEquals("Pinch",
                unitOfMeasure.get().getDescription());
    }
    @Test
    public void findByDescriptionCup() {
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Cup");

//        assertNull(unitOfMeasure);
        assertEquals("Cup",
                unitOfMeasure.get().getDescription());
    }
}