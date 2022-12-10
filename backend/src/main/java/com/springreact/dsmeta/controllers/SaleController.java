package com.springreact.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springreact.dsmeta.entities.Sale;
import com.springreact.dsmeta.services.SaleService;

@RestController
@RequestMapping(value="/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping(value="/{id}")
	public Sale findById(@PathVariable Long id){
		return service.findById(id);
	}
	
	@GetMapping
	public Page<Sale> findAll(Pageable pageable) {
		return service.findAll(pageable);
	}
	
	@GetMapping(value="/bydate")
	public Page<Sale> findByDateBetween(
			@RequestParam(value="minDate", defaultValue = "") String minDate, 
			@RequestParam(value="maxDate", defaultValue = "") String maxDate, 
			Pageable pageable) {
		return service.findByDateBetween(minDate, maxDate, pageable);
	}
}
