package com.fikogroup.sprgurufb.converters;

import com.fikogroup.sprgurufb.commands.CategoryCommand;
import com.fikogroup.sprgurufb.domainORmodel.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {


    @Nullable
    @Override
    public Category convert(CategoryCommand source) {
        if (source == null) {
            return null;
        }

        final Category category = new Category();
        category.setId(source.getId());
        category.setDescription(source.getDescription());
        return category;
    }
}
