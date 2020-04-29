package com.fikogroup.sprgurufb.repositories;

import com.fikogroup.sprgurufb.domainORmodel.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure,Long>{
Optional<UnitOfMeasure>findByDescription(String description);

}
