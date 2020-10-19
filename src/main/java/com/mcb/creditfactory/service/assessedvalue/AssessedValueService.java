package com.mcb.creditfactory.service.assessedvalue;

import com.mcb.creditfactory.dto.AssessedValueDto;
import com.mcb.creditfactory.model.AssessedValue;

public interface AssessedValueService {
	
	AssessedValueDto save(AssessedValueDto assessedValueDto);
	
	Integer checkCollateralExist(String type);
	
	AssessedValue getLastValue(String object);
	
}
