package com.infygo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infygo.dto.UserDetailsDto;

@FeignClient(name="infygo-user",url = "http://localhost:9000/")
public interface TicketUserFeign {

	@RequestMapping("/user/{userId}")
	UserDetailsDto getSpecificFlight(@PathVariable ("userId") String userId);
}