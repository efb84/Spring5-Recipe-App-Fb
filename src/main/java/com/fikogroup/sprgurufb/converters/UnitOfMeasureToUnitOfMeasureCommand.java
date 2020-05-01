package com.fikogroup.sprgurufb.converters;

import com.fikogroup.sprgurufb.commands.UnitOfMeasureCommand;
import com.fikogroup.sprgurufb.domainORmodel.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand  implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
        if(source==null){
            return null;
        }
        UnitOfMeasureCommand unitOfMeasureCommand=new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(source.getId());
        unitOfMeasureCommand.setDescription(source.getDescription());
        return unitOfMeasureCommand;
    }
}
