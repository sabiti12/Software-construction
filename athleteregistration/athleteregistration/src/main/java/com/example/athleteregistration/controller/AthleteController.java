package com.example.athleteregistration.controller;


	import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.athleteregistration.payload.AthleteRequest;
import com.example.athleteregistration.payload.AthleteResponse;
import com.example.athleteregistration.security.CurrentUser;
import com.example.athleteregistration.security.UserPrincipal;
import com.example.athleteregistration.service.AthleteService;
@RestController
@RequestMapping("/api/athlete")
public class AthleteController {
	
	@Autowired
	private AthleteService athleteService;
	
	@GetMapping("/getallathletes")
    public List<AthleteResponse> getAllAthletes() {
        return athleteService.getAllAthletes();
    }
	
	@DeleteMapping("/deleteathlete /{id}")
	public String deleteAthleteById(@PathVariable("id") Long athleteId)
	
	{
		return athleteService.deleteAthlete(athleteId); 
	}
	
	//@GetMapping("/myselection")
    //public List<AthleteResponse> getAthleteSelection(@CurrentUser UserPrincipal currentUser, @Valid @RequestBody AthleteResponse request) {
       // return athleteService.getAthleteSelection(currentUser, request);
    //}
	
	@PostMapping("/createathlete")
    public String createathlete(@Valid @RequestBody AthleteRequest request) {
        return athleteService.createAthlete(request);
    }
	
}