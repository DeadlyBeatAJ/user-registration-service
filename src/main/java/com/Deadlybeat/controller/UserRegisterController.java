package com.Deadlybeat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Deadlybeat.model.User;
import com.Deadlybeat.repository.userRegistrationRepository;

@RestController
@CrossOrigin(origins = "*")
public class UserRegisterController {

	@Autowired
	private userRegistrationRepository repository;
	
	@PostMapping("/register")
	public String Register(@RequestBody User user) {
		repository.save(user);
		return "hi "+user.getName()+" your Registration completed successfully.";
	}
	
	@GetMapping("/getAllUsers")
	public List<User> findAllUsers(){
		return repository.findAll();
	}
	
	@GetMapping("/findUser/{email}")
	public List<User> findAllUsers(	@PathVariable String email){
		return repository.findByEmail(email);
	}
	
	@DeleteMapping("cancel/{id}")
	public List<User> cancelRegistration(@PathVariable int id){
		repository.deleteById(id);
		return repository.findAll();
	}
	 
}
