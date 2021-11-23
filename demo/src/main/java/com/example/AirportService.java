package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    @Autowired
    public AirportService(AirportRepository airportRepository){
        this.airportRepository = airportRepository;
    }

    public AirportModel addUser(AirportModel airportModel){
        return airportRepository.save(airportModel);

    } 

    public AirportModel logIn(AirportModel airportModel){
        return airportRepository.save(airportModel);
    }

    public List<AirportModel> getUsers(){
        return airportRepository.findAll();
    }


}

        

