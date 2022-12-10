package com.springreact.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springreact.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	Page<Sale> findByDateBetween(LocalDate min, LocalDate max, Pageable pageable);
	
	
}