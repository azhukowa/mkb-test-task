package com.mcb.creditfactory.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.CollateralDao;
import com.mcb.creditfactory.service.airplane.AirplaneService;
import com.mcb.creditfactory.service.car.CarService;


@Service
public class CollateralService {

	@Autowired
	private CarService carService;

	@Autowired
	private AirplaneService airplaneService;
	

	@SuppressWarnings("ConstantConditions")
	public Long saveCollateral(Collateral object) {

		if (!(object instanceof Collateral)) {
			throw new IllegalArgumentException();
		}
		
		CommonCollateralService commonCollateralService = getObjectService(object.getCollateralType());
		
		if(commonCollateralService.approve(object)) {
			CollateralDao collateralDao = commonCollateralService.transferDtoToDao(object);
			commonCollateralService.save(collateralDao);
			return commonCollateralService.getId(collateralDao);
		} else {
			throw new RuntimeException("Collateral didn't pass the approval");
		}

	}
	
	
	public Collateral getInfo(Collateral object) {
		
		if (!(object instanceof Collateral)) {
			throw new IllegalArgumentException();
		}
		
		CommonCollateralService commonCollateralService = getObjectService(object.getCollateralType());
		
		CollateralDao collateralDao = commonCollateralService.transferDtoToDao(object);
		Long id = commonCollateralService.getId(collateralDao);
		Optional<CollateralDao> inf = commonCollateralService.loadInfo(id);
				
		return commonCollateralService.transferDaoToDto(inf.get());	
		
	}
	
	
	public CommonCollateralService getObjectService(CollateralType type) {
		switch (type) {
		case CAR:
			return (CommonCollateralService) carService;
		case AIRPLANE:
			return (CommonCollateralService) airplaneService;
		default:
			throw new IllegalArgumentException();
		}

	}
	

}
