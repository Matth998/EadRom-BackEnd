package com.zoneu.ead.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoneu.ead.model.CategoryModel;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long>{

	public List<CategoryModel> findAllByDescriptionContainingIgnoreCase(String description);
	
}