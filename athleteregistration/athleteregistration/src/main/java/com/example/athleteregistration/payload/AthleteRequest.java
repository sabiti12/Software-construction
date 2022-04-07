package com.example.athleteregistration.payload;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class AthleteRequest {
   
	   @NotBlank
	    @Size(min = 4, max = 40)
	    private String name;

	    @NotBlank
	    @Size(min = 3, max = 15)
	    private String sex;
	    
	    @NotBlank
	    @Size(min = 3, max = 15)
	    private String sport;
	    
	    @NotBlank
	    @Size(min = 3, max = 15)
	    private String weight;

	    @NotBlank
	    @Size(max = 40)
	    @Email
	    private String email;
	    
	    @NotBlank
	    @Size(max = 40)
	    private String course;
	    
	    @NotBlank
	    @Size(max = 40)
	    private String nationality;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public String getSport() {
			return sport;
		}

		public void setSport(String sport) {
			this.sport = sport;
		}

		public String getWeight() {
			return weight;
		}

		public void setWeight(String weight) {
			this.weight = weight;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getCourse() {
			return course;
		}

		public void setCourse(String course) {
			this.course = course;
		}

		public String getNationality() {
			return nationality;
		}

		public void setNationality(String nationality) {
			this.nationality = nationality;
		}

	    

}