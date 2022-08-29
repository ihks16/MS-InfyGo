package com.infygo.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infygo.dto.UserDetailsDto;
import com.infygo.entity.UserDetails;
import com.infygo.exception.UserNotExist;
import com.infygo.exception.UserAllReadyExist;
import com.infygo.repository.UserRepository;
import com.infygo.service.UserService;


@RestController
@RequestMapping()
@Validated
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/register")
	public ResponseEntity<String> addUsers(@Valid @RequestBody UserDetailsDto userDetailsDto) throws userAllReadyExist{
		userService.addUsers(userDetailsDto);
		
		return new  ResponseEntity<String>("User registered Successfully",HttpStatus.OK);
	}
	
	
	@GetMapping("/user")
	public List<UserDetailsDto> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/present/name/{name}/phone/{phone}")
	public Boolean present(@PathVariable("name") String name,@PathVariable("phone") String phone) {
		return userService.userExistOrNot(name, phone);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserDetailsDto userDetailsDto) throws UserNotExist{
		userService.login(userDetailsDto);
		return new ResponseEntity<String>("You have logged in successfully",HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/user/{userId}")
	public UserDetailsDto getuser(@PathVariable("userId") String userId) throws UserNotExist {
		return userService.findbyId(userId);
	}
}
