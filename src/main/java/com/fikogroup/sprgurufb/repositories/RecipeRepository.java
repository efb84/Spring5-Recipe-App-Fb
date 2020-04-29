package com.fikogroup.sprgurufb.repositories;

import com.fikogroup.sprgurufb.domainORmodel.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}
