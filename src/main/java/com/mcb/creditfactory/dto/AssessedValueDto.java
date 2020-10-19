package com.mcb.creditfactory.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssessedValueDto {
	
	@Null
	private Long id;
	
	@NotNull
	private String collateralType;
	
	@NotNull
	private BigDecimal value;
	
	@NotNull
	private LocalDateTime date;


}
