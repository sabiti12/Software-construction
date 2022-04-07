package com.example.athleteregistration.model;

import com.example.athleteregistration.model.audit.DateAudit;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "athlete")
public class Athlete extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    @NotBlank
    @Size(max = 40)
    private String name;
    
    @NotBlank
    @Size(max = 40)
    private String sport;
    
    
    //@NotBlank
    //@Size(max = 15)
   // private String username;

    @NotBlank
    @Size(max = 15)
    private String sex;
    
//    @NotBlank
//    @Size(max = 15)
//    private String dob;
    
    @NotBlank
    @Size(max = 15)
    private String nationality;
    
    @NotBlank
    @Size(max = 40)
    private String course;
    
    @NotBlank
    @Size(max = 15)
    private String weight;
    
   
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

   
       public Athlete() {

    }

    public Athlete(String name, String sport, String email, String weight, String sex, String nationality, String course ) {
        this.name = name;
       // this.username = username;
        this.sport = sport;
        this.email = email;
        this.weight = weight;
        this.sex = sex;
        this.nationality = nationality;
        this.course = course;
//        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   // public String getUsername() {
      //  return username;
  //  }

//    public void setUsername(String username) {
//        this.username = username;
//    }

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
    
//    
//    public String getDob() {
//        return dob;
//    }
//
//    public void setDob(String dob) {
//        this.dob = dob;
//    
//    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    
    }
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    
    }
    
    
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
        
    
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
