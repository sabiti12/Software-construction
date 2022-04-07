package com.example.athleteregistration.util;

	
	import com.example.athleteregistration.model.Athlete;
	import com.example.athleteregistration.model.User;
//	import com.example.athleteregistration.payload.ChoiceResponse;
	import com.example.athleteregistration.payload.AthleteResponse;
	import com.example.athleteregistration.payload.UserSummary;

	import java.time.Instant;
	import java.util.List;
	import java.util.Map;
	import java.util.stream.Collectors;

	public class ModelMapper {

	    public static AthleteResponse mapPollToPollResponse(Athlete athlete,User creator) {
	        AthleteResponse athleteResponse = new AthleteResponse();
	        athleteResponse.setId(athlete.getId());
	        athleteResponse.setSport(athlete.getSport());
	        athleteResponse.setWeight(athlete.getWeight());
	        athleteResponse.setNationality(athlete.getNationality());
	        athleteResponse.setCourse(athlete.getCourse());
	        athleteResponse.setEmail(athlete.getEmail());
	      //  athleteResponse.setDob(athlete.getDob());
	        athleteResponse.setSex(athlete.getSex());
	        





	        UserSummary creatorSummary = new UserSummary(creator.getId(), creator.getUsername(), creator.getName());
	        //AthleteResponse.setCreatedBy(creatorSummary);

	       
	       
	        return athleteResponse;
	    }
	}

