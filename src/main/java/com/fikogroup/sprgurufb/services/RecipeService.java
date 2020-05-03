package com.fikogroup.sprgurufb.services;

import com.fikogroup.sprgurufb.commands.RecipeCommand;
import com.fikogroup.sprgurufb.domainORmodel.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand findCommandById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);

    void deleteById(Long idToDelete);

}
