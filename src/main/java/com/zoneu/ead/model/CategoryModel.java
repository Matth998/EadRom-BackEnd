package com.zoneu.ead.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_category")
public class CategoryModel {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotBlank
		@Size(min = 4, max = 100)
		private String description;
		
		private String photo;

		@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
		@JsonIgnoreProperties("category")
		private List<CourseModel> course;
		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		
		public String getPhoto() {
			return photo;
		}

		public void setPhoto(String photo) {
			this.photo = photo;
		}

		public List<CourseModel> getCourse() {
			return course;
		}

		public void setCourse(List<CourseModel> course) {
			this.course = course;
		}

		
}
