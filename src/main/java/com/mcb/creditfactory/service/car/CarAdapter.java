package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.service.assessedvalue.AssessedValueService;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@AllArgsConstructor
public class CarAdapter implements CollateralObject {
    
	private CarDto car;
    
    private AssessedValueService assessedValueService;
    
    @Override
    public BigDecimal getValue() {
        //return car.getValue();
    	return assessedValueService.getLastValue(this.getType().name()).getValue();
    }

    @Override
    public Short getYear() {
        return car.getYear();
    }

    @Override
    public LocalDate getDate() {
        // Для автомобилей дата оценки не используется, поэтому всегда берем текущую - old
        //return LocalDate.now();
    	return assessedValueService.getLastValue(this.getType().name()).getDate().toLocalDate();
    }

    @Override
    public CollateralType getType() {
    	return car.getCollateralType();
    }
    
}
