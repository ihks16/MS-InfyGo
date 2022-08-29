package com.infygo.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infygo.dto.CreditcardDetailsDto;
import com.infygo.entity.CreditcardDetails;
import com.infygo.repository.CreditcardDetailRepository;

@Service
public class CardService {
		
	@Autowired 
	private CreditcardDetailRepository creditcardDetailRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
//	public ResponseEntity<String> makePayment(CreditcardDetailsDto creditcardDetailsDto){
//		
//		Optional<CreditcardDetails> optional = creditcardDetailRepository.findById(creditcardDetailsDto.getCardNumber());
//		if(!optional.isPresent()) {
//			return new ResponseEntity<String>("Credit card with this no is not available", HttpStatus.BAD_REQUEST);
//		}
//		CreditcardDetails creditcardDetails = optional.get();
//		if(!(creditcardDetails.getApin().equals(creditcardDetailsDto.getApin()))&&
//				(creditcardDetails.getCardHolderName().equals(creditcardDetailsDto.getCardHolderName()))&&
//				(creditcardDetails.getCvv().equals(creditcardDetailsDto.getCvv()))&&
//				(creditcardDetails.getExpiryMonth().equals(creditcardDetailsDto.getExpiryMonth()))&&
//				(creditcardDetails.getExpiryYear().equals(creditcardDetailsDto.getExpiryYear()))){
//			return new ResponseEntity<String>("Valid Creadit Card", HttpStatus.ACCEPTED);
//		}else
//		{
//			return new ResponseEntity<String>("you entered incorrect data for creadit carad", HttpStatus.BAD_REQUEST);
//		}
//	}
//	
	public ResponseEntity<String> makePayment(CreditcardDetailsDto creditcardDetailsDto){
		creditcardDetailRepository.saveAndFlush(this.modelMapper.map(creditcardDetailsDto, CreditcardDetails.class));	
		
		return new ResponseEntity<String>("Valid Creadit Card", HttpStatus.ACCEPTED);
		
	}

}
