package io.bhupedra.spring5recipeapp.services;


import io.bhupedra.spring5recipeapp.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
