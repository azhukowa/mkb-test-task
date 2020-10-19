package com.mcb.creditfactory.service.airplane;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.service.assessedvalue.AssessedValueService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class AirplaneAdapter implements CollateralObject{
	
	private AirplaneDto airplain;

	private AssessedValueService assessedValueService;
	

	@Override
	public BigDecimal getValue() {
		return assessedValueService.getLastValue(this.getType().name()).getValue();
	}

	@Override
	public Short getYear() {
		return airplain.getYear();
	}

	@Override
	public LocalDate getDate() {
		return assessedValueService.getLastValue(this.getType().name()).getDate().toLocalDate();
	}

	@Override
	public CollateralType getType() {
		return airplain.getCollateralType();
	}

}
