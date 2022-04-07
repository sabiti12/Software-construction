package com.example.athleteregistration.repository;

import com.example.athleteregistration.model.Athlete;
import com.example.athleteregistration.model.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {
	 Optional<User> findByEmail(String email);

	    List<User> findByIdIn(List<Long> athleteIds);

	    Optional<User> findByName(String sex);
	    
	    Optional<User> findBySport(String sport);

	    Boolean existsBySex(String sex);

	    Boolean existsByEmail(String email);
	    
	    Boolean existsBySport(String sport);
}
