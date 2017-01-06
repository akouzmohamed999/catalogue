package com.cat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cat.dao.IProduitRepository;
import com.cat.entities.Produit;

@RestController
public class ProduitController {
	
	@Autowired
	private IProduitRepository produitrepository;
	
	@RequestMapping("/test")
	public String test(){
		return "test";
	}
	
	@RequestMapping("/save")
	public Produit saveProduit(Produit produit){
		produitrepository.save(produit);
		return produit;
	}
	
	@RequestMapping("/all")
	public List<Produit> getAll(){
		return produitrepository.findAll();
	}
	
	@RequestMapping("/update")
	public Produit update(Produit produit){
		
		produitrepository.saveAndFlush(produit);
		return produit;
	}
	@RequestMapping("/produits")
	public Page<Produit> produits(int page){
		return  produitrepository.findAll(new PageRequest(page, 5));
	}
	
	@RequestMapping("/produitsByMc")
	public Page<Produit> produitsByMc(int page, String mc){
		return produitrepository.produitsByMc("%"+mc+"%",new PageRequest(page, 5));
	}
	
	@RequestMapping("/get")
	public Produit get(Long reference){
		return produitrepository.findOne(reference);
	}
	
	@RequestMapping("/remove")
	public boolean remove(Long reference){
		produitrepository.delete(reference);
		return true;
	}
	
	
	public List<Produit> findByDescription(String description){
		return produitrepository.findByDescription(description);
	}
	
	@RequestMapping("/produitsByDesc")
	public Page<Produit> findByDescription(String description, int page){
		if(description.equals("")){
			return produits(page);
		}else{
			return produitrepository.findByDescription(description, new PageRequest(page, 5));	
		}
		
	}

}
