package com.fikogroup.sprgurufb.converters;

import com.fikogroup.sprgurufb.commands.IngredientCommand;
import com.fikogroup.sprgurufb.domainORmodel.Ingredient;
import com.fikogroup.sprgurufb.domainORmodel.Recipe;
import com.fikogroup.sprgurufb.domainORmodel.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {


    private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
        this.uomConverter = uomConverter;
    }


    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {

        if(source==null){
             return null;
        }

        final Ingredient ingredient=new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setDescription(source.getDescription());
        ingredient.setAmount(source.getAmount());
        ingredient.setUom(uomConverter.convert(source.getUnitOfMeasure()));

        return ingredient;
    }
}
