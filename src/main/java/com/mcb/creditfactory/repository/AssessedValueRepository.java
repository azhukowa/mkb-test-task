package com.mcb.creditfactory.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.mcb.creditfactory.model.AssessedValue;


@Repository
public interface AssessedValueRepository extends CrudRepository<AssessedValue, Long>  {

	AssessedValue findFirstByCollateralTypeOrderByDateDesc(String collateralType);
	
}
