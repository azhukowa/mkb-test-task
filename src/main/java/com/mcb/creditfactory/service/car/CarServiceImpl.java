package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.model.CollateralDao;
import com.mcb.creditfactory.repository.CarRepository;
import com.mcb.creditfactory.service.CommonCollateralService;
import com.mcb.creditfactory.service.assessedvalue.AssessedValueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarServiceImpl implements CarService, CommonCollateralService {
    @Autowired
    private ExternalApproveService approveService;

    @Autowired
    private CarRepository carRepository;

	@Autowired
	private AssessedValueService assessedValueService;
	
	
    @Override
    public boolean approve(CarDto dto) {
        return approveService.approve(new CarAdapter(dto, assessedValueService)) == 0;
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Optional<Car> load(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public Car fromDto(CarDto dto) {
        return new Car(
                dto.getId(),
                dto.getBrand(),
                dto.getModel(),
                dto.getPower(),
                dto.getYear()
                //,dto.getValue()
        );
    }

    @Override
    public CarDto toDTO(Car car) {
        return new CarDto(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getPower(),
                car.getYear()
                //,car.getValue()
        );
    }

    @Override
    public Long getId(Car car) {
        return car.getId();
    }

	@Override
	public CollateralDao transferDtoToDao(Collateral dto) {
		return fromDto((CarDto)dto);
	}

	@Override
	public CollateralDao save(CollateralDao dao) {
		return save((Car)dao);
	}

	@Override
	public Long getId(CollateralDao dao) {
		return getId((Car)dao);
	}

	@Override
	public boolean approve(Collateral dto) {
		return approve((CarDto)dto);
	}

	@Override
	public Optional<CollateralDao> loadInfo(Long id) {

		Optional<Car> obj = load(id);
		Optional<CollateralDao> objAsCollateralDao = obj
				.filter(Car.class::isInstance)
				.map(Car.class::cast);
		
		return objAsCollateralDao;
	}
	
	@Override
	public Collateral transferDaoToDto(CollateralDao dao) {
		return (Collateral)toDTO((Car)dao);
	}
}
