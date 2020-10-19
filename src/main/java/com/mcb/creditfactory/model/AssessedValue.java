package com.mcb.creditfactory.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Table(name="ASSESSED_VALUE")
public class AssessedValue {

    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "collateral_type")
	private String collateralType;
	
//	@Column(name = "collateral_type_id")
//	private Long collateralTypeId;	
//	
	@Column(name = "assessed_value")
	private BigDecimal value;
	
	@Column(name = "year_of_issue")
	private LocalDateTime date;
	
}
