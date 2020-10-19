package com.mcb.creditfactory.controller;

import com.mcb.creditfactory.dto.AssessedValueDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.service.CollateralService;
import com.mcb.creditfactory.service.assessedvalue.AssessedValueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollateralObjectController {
    @Autowired
    private CollateralService collateralService;
    
    @Autowired
    private AssessedValueService assessedValueService;

    
    @PostMapping("/collateral/save")
    public HttpEntity<Long> save(@RequestBody Collateral object) {
        Long id = collateralService.saveCollateral(object);
        return id != null ? ResponseEntity.ok(id) : ResponseEntity.badRequest().build();
    }

    @PostMapping("/collateral/info")
    public HttpEntity<Collateral> getInfo(@RequestBody Collateral object) {
        Collateral info = collateralService.getInfo(object);
        return info != null ? ResponseEntity.ok(info) : ResponseEntity.notFound().build();
    }
    
    @PostMapping("/assessedvalue/add")
    public HttpEntity<AssessedValueDto> saveAssessedValue(@Validated @RequestBody AssessedValueDto object){
    	AssessedValueDto response = assessedValueService.save(object);
    	return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    	
    }
    
    
}
