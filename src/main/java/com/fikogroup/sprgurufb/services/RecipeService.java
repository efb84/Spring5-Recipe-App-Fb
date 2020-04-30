package com.fikogroup.sprgurufb.services;

import com.fikogroup.sprgurufb.domainORmodel.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

}
