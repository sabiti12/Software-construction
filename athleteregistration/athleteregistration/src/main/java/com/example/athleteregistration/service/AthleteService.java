package com.example.athleteregistration.service;



	import com.example.athleteregistration.model.Athlete;
import com.example.athleteregistration.payload.AthleteRequest;
import com.example.athleteregistration.payload.AthleteResponse;
import com.example.athleteregistration.repository.AthleteRepository;
import com.example.athleteregistration.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AthleteService {
	@Autowired
	private AthleteRepository athleteRepository;
	public List<AthleteResponse> getAllAthletes() {
		List<AthleteResponse> athletes = new ArrayList<>();
		
		for(Athlete athlete : athleteRepository.findAll()) {
			
			AthleteResponse resp = new AthleteResponse();
			
			resp.setId(athlete.getId());
			resp.setName(athlete.getName());
			resp.setSex(athlete.getSex());
			resp.setWeight(athlete.getWeight());
			resp.setNationality(athlete.getNationality());
			resp.setSport(athlete.getSport());
			resp.setCourse(athlete.getCourse());
			resp.setEmail(athlete.getEmail());
			//resp.setUsername(athlete.getUsername());



						
			athletes.add(resp);
			
		}
		
		return athletes;
	}
	public List<AthleteResponse> getAthleteSelection(UserPrincipal currentUser, AthleteResponse request) {
		List<AthleteResponse> athletes = new ArrayList<>();
		return athletes;
	}
	
	public String createAthlete(AthleteRequest request) {
		
		System.out.println("We are going to save");
		
		String response = "Failed";
		
		Athlete athlete = new Athlete();
		
		
		athlete.setName(request.getName());
		athlete.setSex(request.getSex());
		athlete.setWeight(request.getWeight());
		athlete.setNationality(request.getNationality());
		athlete.setSport(request.getSport());
		athlete.setCourse(request.getCourse());
		athlete.setEmail(request.getEmail());
	//	athlete.setUsername(request.getUsername());

		Athlete saved = athleteRepository.save(athlete);
		
		return saved != null ? "Saved" :  response;
	}
	
	
	public String deleteAthlete(Long id) {
		  
		  Optional<Athlete> toDelete = id != null ? athleteRepository.findById(id) : Optional.empty();
		 
		  if(toDelete.isPresent()) {
			 
			  try {
				  athleteRepository.delete(toDelete.get());
				  return "Deleted";
			} catch (Exception e) {
				// TODO: handle exception
			}

			}
return "deleted successfully";
	}
}

