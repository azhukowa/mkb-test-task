package com.mcb.creditfactory.service.assessedvalue;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Enums;
import com.mcb.creditfactory.dto.AssessedValueDto;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.AssessedValue;
import com.mcb.creditfactory.repository.AssessedValueRepository;
import com.mcb.creditfactory.service.CollateralService;

@Service
public class AssessedValueServiceImpl implements AssessedValueService{
	
	@Autowired
	AssessedValueRepository assessedValueRepository;
	
	@Autowired
	CollateralService collateralServise;

	@Override
	public AssessedValueDto save(AssessedValueDto assessedValueDto) {
		
		if(checkCollateralExist(assessedValueDto.getCollateralType()) != 0) {
			throw new IllegalArgumentException("Collateral type doesn't exist");
		}
		
		AssessedValue assessedValue = new AssessedValue();
        BeanUtils.copyProperties(assessedValueDto, assessedValue);
        
        AssessedValue storedAssessedValue = assessedValueRepository.save(assessedValue);
        
        AssessedValueDto returnValue = new AssessedValueDto();
        BeanUtils.copyProperties(storedAssessedValue, returnValue);
		return returnValue;
	}
	
	@Override
	public Integer checkCollateralExist(String type) {

		if (Enums.getIfPresent(CollateralType.class, type).orNull() == null) {
			return 1;
		}
		
		return 0;

	}
	
	@Override
	public AssessedValue getLastValue(String objectType) {
		AssessedValue assessedValue =  assessedValueRepository.findFirstByCollateralTypeOrderByDateDesc(objectType);
		if (assessedValue == null) throw new RuntimeException("Assessed value for collateral doesn't exist");
		return assessedValue;
	}

	

}
