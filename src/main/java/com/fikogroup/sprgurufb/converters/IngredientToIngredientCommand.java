package com.fikogroup.sprgurufb.converters;

import com.fikogroup.sprgurufb.commands.IngredientCommand;
import com.fikogroup.sprgurufb.commands.UnitOfMeasureCommand;
import com.fikogroup.sprgurufb.domainORmodel.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;


    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }


    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        if (source == null) {
            return null;
        }
        final IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(source.getId());
        ingredientCommand.setDescription(source.getDescription());
        ingredientCommand.setAmount(source.getAmount());

        ingredientCommand.setUnitOfMeasure(unitOfMeasureToUnitOfMeasureCommand.convert(source.getUom()));

        return ingredientCommand;
    }
}





