package com.fikogroup.sprgurufb.services;

import com.fikogroup.sprgurufb.commands.UnitOfMeasureCommand;
import com.fikogroup.sprgurufb.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.fikogroup.sprgurufb.domainORmodel.UnitOfMeasure;
import com.fikogroup.sprgurufb.repositories.UnitOfMeasureRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UnitOfMeasureServiceImplTest {

    UnitOfMeasureServiceImpl unitOfMeasureService;
    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand
            = new UnitOfMeasureToUnitOfMeasureCommand();


    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        unitOfMeasureService= new UnitOfMeasureServiceImpl(unitOfMeasureRepository, unitOfMeasureToUnitOfMeasureCommand);
    }

    @Test
    public void listAllUoms() throws Exception{
        //given
        Set<UnitOfMeasure> unitOfMeasuresList=new HashSet<>();
        UnitOfMeasure unit1=new UnitOfMeasure();
        unit1.setId(1L);
        unitOfMeasuresList.add(unit1);

        UnitOfMeasure unit2=new UnitOfMeasure();
        unit2.setId(2L);
        unitOfMeasuresList.add(unit2);

        when(unitOfMeasureRepository.findAll()).thenReturn(unitOfMeasuresList);


        //when

        Set<UnitOfMeasureCommand> unitOfMeasureCommands=unitOfMeasureService.listAllUoms();

        //then
        assertEquals(2,unitOfMeasureCommands.size());
        verify(unitOfMeasureRepository,times(1)).findAll();


    }
}
