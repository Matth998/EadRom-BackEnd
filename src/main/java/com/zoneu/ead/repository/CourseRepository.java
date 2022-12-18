package com.zoneu.ead.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoneu.ead.model.CourseModel;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel, Long>{

	public List<CourseModel> findAllByTitleContainingIgnoreCase(String title);
	
}
