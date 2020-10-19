package com.mcb.creditfactory.service;

import java.util.Optional;

import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.model.CollateralDao;

public interface CommonCollateralService {
	
	
	CollateralDao transferDtoToDao (Collateral dto);
	
	CollateralDao save(CollateralDao dao);
	
	Long getId(CollateralDao dao);
	
	boolean approve(Collateral dto);
	
	Optional<CollateralDao> loadInfo(Long id);
    
	Collateral transferDaoToDto(CollateralDao dao);

}
