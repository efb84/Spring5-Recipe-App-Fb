package com.fikogroup.sprgurufb.services;

import com.fikogroup.sprgurufb.commands.IngredientCommand;
import com.fikogroup.sprgurufb.domainORmodel.Ingredient;


public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId,Long ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand command);

    void deleteById(Long recipeId, Long ingredientId);
}
