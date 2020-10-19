package com.mcb.creditfactory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="AIRPLANE")
public class Airplane implements CollateralDao {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String manufacturer;

    @Column(name = "year_of_issue")
    private Short year;

    @Column(name = "fuel_сapacity")
    private Integer fuelCapacity;
    
    private Integer seats;
	

}
