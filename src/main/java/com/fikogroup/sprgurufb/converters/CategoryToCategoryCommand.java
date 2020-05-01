package com.fikogroup.sprgurufb.converters;

import com.fikogroup.sprgurufb.commands.CategoryCommand;
import com.fikogroup.sprgurufb.domainORmodel.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {


    @Nullable
    @Override
    public CategoryCommand convert(Category source) {


        if(source==null) {
            return null;
        }

        CategoryCommand categoryCommand=new CategoryCommand();
        categoryCommand.setId(source.getId());
        categoryCommand.setDescription(source.getDescription());


        return categoryCommand;
    }
}
