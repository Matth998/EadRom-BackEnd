package com.zoneu.ead.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoneu.ead.model.CourseModel;
import com.zoneu.ead.repository.CourseRepository;


@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CourseController {

	@Autowired
	private CourseRepository repository;
	
	@GetMapping
	public ResponseEntity<List<CourseModel>> GetAll(){
		
		return ResponseEntity.ok(repository.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CourseModel> GetById(@PathVariable long id){
		
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<CourseModel>> GetByTitle(@PathVariable String title){
		
		return ResponseEntity.ok(repository.findAllByTitleContainingIgnoreCase(title));
		
	}
	
	@PostMapping
	public ResponseEntity<CourseModel> postBody(@RequestBody CourseModel course){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(course));
		
	}
	
	@PutMapping
	public ResponseEntity<CourseModel> putBody(@RequestBody CourseModel course){
		
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(course));
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		
		repository.deleteById(id);
		
	}
	
	
}
