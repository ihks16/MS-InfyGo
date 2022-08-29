package com.infygo.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infygo.dto.CreditcardDetailsDto;
import com.infygo.service.CardService;

@RestController
@RequestMapping("/payment")
@Validated
public class CardController {

		
	@Autowired
	private CardService cardService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	public ResponseEntity<String> payment(@Valid @RequestBody CreditcardDetailsDto creditcardDetailsDto){
		return cardService.makePayment(creditcardDetailsDto);
		
	}
	

}
