package com.mcb.creditfactory.service.airplane;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.model.CollateralDao;
import com.mcb.creditfactory.repository.AirplaneRepository;
import com.mcb.creditfactory.service.CommonCollateralService;
import com.mcb.creditfactory.service.assessedvalue.AssessedValueService;

@Service
public class AirplaneServiceImpl implements AirplaneService, CommonCollateralService {

	@Autowired
    private ExternalApproveService approveService;
	
	@Autowired
	private AirplaneRepository airplaneRepository;
	
	@Autowired
	private AssessedValueService assessedValueService;

	@Override
	public CollateralDao save(CollateralDao dao) {
		return airplaneRepository.save((Airplane)dao);
	}

	@Override
	public CollateralDao transferDtoToDao(Collateral dto) {
		Airplane airplane = new Airplane();
		BeanUtils.copyProperties(dto, airplane);
		return airplane;
	}

	@Override
	public Long getId(CollateralDao dao) {
		Airplane airplane = (Airplane)dao;
		return airplane.getId();
	}
	
	
	@Override
	@SuppressWarnings("unused")
	public boolean approve(Collateral dto) {
		return approveService.approve(new AirplaneAdapter((AirplaneDto)dto, assessedValueService)) == 0;
	}

	@Override
	public Optional<CollateralDao> loadInfo(Long id) {
		Optional<Airplane> obj = airplaneRepository.findById(id);
		Optional<CollateralDao> objAsCollateralDao = obj
				.filter(Airplane.class::isInstance)
				.map(Airplane.class::cast);
		
		return objAsCollateralDao;
	}

	@Override
	public Collateral transferDaoToDto(CollateralDao dao) {
		Collateral dto = new AirplaneDto();
		BeanUtils.copyProperties(dao, dto);
		return dto;
	}
	
	

}
