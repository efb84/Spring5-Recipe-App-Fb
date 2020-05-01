package com.fikogroup.sprgurufb.converters;

import com.fikogroup.sprgurufb.commands.RecipeCommand;
import com.fikogroup.sprgurufb.domainORmodel.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

        private CategoryCommandToCategory categoryCommandToCategory;
        private IngredientCommandToIngredient ingredientCommandToIngredient;
        private NotesCommandToNotes notesCommandToNotes;

    public RecipeCommandToRecipe(CategoryCommandToCategory categoryCommandToCategory, IngredientCommandToIngredient ingredientCommandToIngredient, NotesCommandToNotes notesCommandToNotes) {
        this.categoryCommandToCategory = categoryCommandToCategory;
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.notesCommandToNotes = notesCommandToNotes;
    }

    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
        if(source==null){
            return null;
        }
        final Recipe recipe=new Recipe();
        recipe.setId(source.getId());
        recipe.setDescription(source.getDescription());
        recipe.setPrepTime(source.getPrepTime());
        recipe.setCookTime(source.getCookTime());
        recipe.setServings(source.getServings());
        recipe.setSource(source.getSource());
        recipe.setUrl(source.getUrl());
        recipe.setDifficulty(source.getDifficulty());
        recipe.setDirections(source.getDirections());

        recipe.setNotes(notesCommandToNotes.convert(source.getNotes()));

        if(source.getCategories()!=null&&source.getCategories().size()>0){
           source.getCategories().forEach(categoryCommand -> recipe.getCategories().add(categoryCommandToCategory.convert(categoryCommand)));
        }

        if(source.getIngredients()!=null &&source.getIngredients().size()>0){
            source.getIngredients().forEach(ingredientCommand -> recipe.getIngredients().add(ingredientCommandToIngredient.convert(ingredientCommand)));
        }
        return recipe;
    }
}

