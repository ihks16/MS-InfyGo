package com.infygo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infygo.entity.PassengerDetails;

public interface PassengerRepository extends JpaRepository<PassengerDetails, Integer>{

}
