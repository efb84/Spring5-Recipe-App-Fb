package com.fikogroup.sprgurufb.services;

import com.fikogroup.sprgurufb.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
