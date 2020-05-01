package com.fikogroup.sprgurufb.converters;

import com.fikogroup.sprgurufb.commands.NotesCommand;
import com.fikogroup.sprgurufb.domainORmodel.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Nullable
    @Override
    public Notes convert(NotesCommand source) {
        if (source == null) {
            return null;
        }

        final Notes notes = new Notes();
        notes.setId(source.getId());
        notes.setRecipeNotes(source.getRecipeNotes());

        return notes;

    }
}
