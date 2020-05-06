package com.fikogroup.sprgurufb.services;

import com.fikogroup.sprgurufb.commands.UnitOfMeasureCommand;
import com.fikogroup.sprgurufb.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.fikogroup.sprgurufb.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {


    private final UnitOfMeasureRepository unitOfMeasureRepository;

    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;



    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository, UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }


    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {

        Set<UnitOfMeasureCommand> unitOfMeasuresList=new HashSet<>();
        unitOfMeasuresList.addAll(StreamSupport.stream(unitOfMeasureRepository.findAll().
                 spliterator(),false).map(unitOfMeasureToUnitOfMeasureCommand::convert)
                 .collect(Collectors.toSet()));

        return unitOfMeasuresList;
    }
}
