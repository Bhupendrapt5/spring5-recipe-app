package io.bhupedra.spring5recipeapp.repositories;

import io.bhupedra.spring5recipeapp.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure,Long > {

    Optional<UnitOfMeasure> findByDescription(String description);
}
