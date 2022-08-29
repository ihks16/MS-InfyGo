package com.infygo.service;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.infygo.dto.UserDetailsDto;
import com.infygo.entity.UserDetails;
import com.infygo.exception.UserNotExist;
import com.infygo.exception.userAllReadyExist;
import com.infygo.repository.userRepository;

@Service
public class UserService {
	
	@Autowired
	private userRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public void addUsers(UserDetailsDto userDetailsDto) throws userAllReadyExist {
		Boolean bool = userExistOrNot(userDetailsDto.getName(), userDetailsDto.getPhone());
		if(bool) {
			throw new userAllReadyExist("Please login you have all ready register");
		}
		else {
			
			UserDetails userDetails = this.modelMapper.map(userDetailsDto, UserDetails.class);
			userRepository.saveAndFlush(userDetails);
		}
	}
	
	public List<UserDetailsDto> getAllUsers(){
		List<UserDetails> userDetails = new ArrayList<>();
		List<UserDetailsDto> userDetailsDtos=new  ArrayList<>();
		userDetails = userRepository.findAll();
		for(UserDetails user:userDetails) {
			userDetailsDtos.add(this.modelMapper.map(user, UserDetailsDto.class));
		}
		return userDetailsDtos;
	
	}
	
	public Boolean userExistOrNot(String name,String phone) {
		Optional<UserDetails> optional = userRepository.findByNameAndPhone(name, phone);
		return optional.isPresent();
	}

	public void login(UserDetailsDto userDetailsDto) throws UserNotExist {
		// TODO Auto-generated method stub
		Optional<UserDetails> optional = userRepository.findById(userDetailsDto.getUserId());
		if(!optional.isPresent()) {
			throw new UserNotExist("your data is wrong please enter valid data");
		}
		UserDetails userDetails =optional.get();
		UserDetailsDto dto = this.modelMapper.map(userDetails, UserDetailsDto.class);
		
		if(!(dto.getCity().equals(userDetailsDto.getCity()) 
				&& dto.getEmail().equals(userDetailsDto.getEmail())
				&& dto.getName().equals(userDetailsDto.getName())
				&& dto.getPassword().equals(userDetailsDto.getPassword())
				&& dto.getPhone().equals(userDetailsDto.getPhone())
				&& dto.getUserId().equals(userDetailsDto.getUserId()))) {
			throw new UserNotExist("your data is wrong please enter valid data");
		}
	}
	
	public UserDetailsDto findbyId(String id)  throws UserNotExist{
		Optional<UserDetails> optional = userRepository.findById(id);
		if(optional.isPresent()) {
			return this.modelMapper.map(optional.get(), UserDetailsDto.class);
		}else {
			throw new UserNotExist("please entere valid user id ");
		}
	}
}
