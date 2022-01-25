package com.hayden.recipe.services;

import com.hayden.recipe.commands.RecipeCommand;
import com.hayden.recipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(long id);
    RecipeCommand saveRecipeCommand(RecipeCommand command);

}
