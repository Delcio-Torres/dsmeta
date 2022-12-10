package com.springreact.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springreact.dsmeta.entities.Sale;
import com.springreact.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	
	public Sale findById(Long id) {
		Optional<Sale> registro = repository.findById(id);
		return registro.get();
	}
	
	public Page<Sale> findAll(Pageable pageable){
		Page<Sale> result = repository.findAll(pageable); 
		return result;
	}
	
	LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
	
	public Page<Sale> findByDateBetween(String minDate, String maxDate, Pageable pageable) {
		
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		
		return repository.findByDateBetween(min, max, pageable);
	}
}
