package com.mcb.creditfactory.repository;

import org.springframework.stereotype.Repository;

import com.mcb.creditfactory.model.Airplane;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface AirplaneRepository extends CrudRepository<Airplane, Long> {
	
	Airplane findById (String id);
	
}
