package com.nttdata.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.spring.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	/**
	 * Busca productos por su nombre.
	 * 
	 * @param name
	 */
	public List<Product> findByName(String name);
	
}
