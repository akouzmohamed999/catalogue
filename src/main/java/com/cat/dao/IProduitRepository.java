package com.cat.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cat.entities.Produit;

public interface IProduitRepository extends JpaRepository<Produit, Long>{

	@Query("SELECT p from Produit p where p.description like :x")
	Page<Produit> produitsByMc(@Param("x")String mc, Pageable page);

	List<Produit> findByDescription(String description);

	Page<Produit> findByDescription(String description, Pageable page);
	
	
	
}
