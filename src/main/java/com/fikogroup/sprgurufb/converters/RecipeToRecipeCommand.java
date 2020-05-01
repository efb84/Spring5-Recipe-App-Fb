package com.fikogroup.sprgurufb.converters;

import com.fikogroup.sprgurufb.commands.RecipeCommand;
import com.fikogroup.sprgurufb.domainORmodel.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private CategoryToCategoryCommand categoryToCategoryCommand;
    private IngredientToIngredientCommand ingredientToIngredientCommand;
    private NotesToNotesCommand notesToNotesCommand;

    public RecipeToRecipeCommand(CategoryToCategoryCommand categoryToCategoryCommand, IngredientToIngredientCommand ingredientToIngredientCommand, NotesToNotesCommand notesToNotesCommand) {
        this.categoryToCategoryCommand = categoryToCategoryCommand;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.notesToNotesCommand = notesToNotesCommand;
    }

    @Nullable
    @Override
    public RecipeCommand convert(Recipe source) {
        if (source == null) {
            return null;
        }

        final RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(source.getId());
        recipeCommand.setCookTime(source.getCookTime());
        recipeCommand.setPrepTime(source.getPrepTime());
        recipeCommand.setDescription(source.getDescription());
        recipeCommand.setDifficulty(source.getDifficulty());
        recipeCommand.setDirections(source.getDirections());
        recipeCommand.setSource(source.getSource());
        recipeCommand.setServings(source.getServings());
        recipeCommand.setUrl(source.getUrl());

        recipeCommand.setNotes(notesToNotesCommand.convert(source.getNotes()));

        if (source.getCategories() != null && source.getIngredients().size() > 0) {

            source.getCategories().forEach(categoryCommand -> recipeCommand.getCategories()
                    .add(categoryToCategoryCommand.convert(categoryCommand)));

        }
        if(source.getIngredients()!=null && source.getIngredients().size()>0){
            source.getIngredients().forEach(ingredientCommand ->recipeCommand.getIngredients().add(ingredientToIngredientCommand.convert(ingredientCommand)) );
        }
        return recipeCommand;
    }
}
