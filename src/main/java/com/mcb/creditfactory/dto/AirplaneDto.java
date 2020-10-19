package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.mcb.creditfactory.external.CollateralType;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("airplane")
public class AirplaneDto implements  Collateral{

    private Long id;
    private String brand;
    private String model;
    private String manufacturer;
    private Short year;
    private Integer fuelCapacity;
    private Integer seats;
    
    @JsonIgnore
    public CollateralType getCollateralType() {
        return CollateralType.AIRPLANE;
    }
	
}
