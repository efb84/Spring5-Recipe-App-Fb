package com.fikogroup.sprgurufb.services;

import com.fikogroup.sprgurufb.commands.IngredientCommand;



public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId,Long ingredientId);
}
