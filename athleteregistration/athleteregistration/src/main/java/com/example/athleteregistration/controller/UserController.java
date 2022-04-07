package com.example.athleteregistration.controller;

	import com.example.athleteregistration.exception.ResourceNotFoundException;
	import com.example.athleteregistration.model.User;
	import com.example.athleteregistration.payload.*;
	import com.example.athleteregistration.repository.AthleteRepository;
	import com.example.athleteregistration.repository.UserRepository;
	import com.example.athleteregistration.repository.AthleteRepository;
	import com.example.athleteregistration.security.UserPrincipal;
	import com.example.athleteregistration.service.AthleteService;
	import com.example.athleteregistration.security.CurrentUser;
	import com.example.athleteregistration.util.AppConstants;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.access.prepost.PreAuthorize;
	import org.springframework.web.bind.annotation.*;

	@RestController
	@RequestMapping("/api")
	public class UserController {

	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private AthleteRepository athleteRepository;

	   // @Autowired
	   // private AthleteRepository voteRepository;

	    @Autowired
	    private AthleteService athleteService;

	    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	    @GetMapping("/user/me")
	    @PreAuthorize("hasRole('USER')")
	    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
	        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
	        return userSummary;
	    }

	    @GetMapping("/user/checkUsernameAvailability")
	    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
	        Boolean isAvailable = !userRepository.existsByUsername(username);
	        return new UserIdentityAvailability(isAvailable);
	    }

	    @GetMapping("/user/checkEmailAvailability")
	    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
	        Boolean isAvailable = !userRepository.existsByEmail(email);
	        return new UserIdentityAvailability(isAvailable);
	    }

	    @GetMapping("/users/{username}")
	    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
	        User user = userRepository.findByUsername(username)
	                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

	       // long pollCount = pollRepository.countByCreatedBy(user.getId());
	      //  long voteCount = voteRepository.countByUserId(user.getId());

	        UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getName(), user.getCreatedAt());

	        return userProfile;
	    }

//	    @GetMapping("/users/{username}/athletes")
//	    public PagedResponse<AthleteResponse> getAthletessCreatedBy(@PathVariable(value = "username") String username,
//	                                                         @CurrentUser UserPrincipal currentUser,
//	                                                         @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
//	                                                         @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
//	        return athleteService.getAthletesCreatedBy(username, currentUser, page, size);
//	    }
//

//	    @GetMapping("/users/{username}/votes")
//	    public PagedResponse<PollResponse> getPollsVotedBy(@PathVariable(value = "username") String username,
//	                                                       @CurrentUser UserPrincipal currentUser,
//	                                                       @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
//	                                                       @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
//	        return pollService.getPollsVotedBy(username, currentUser, page, size);
	    
//	}

}
