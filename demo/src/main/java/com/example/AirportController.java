package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class AirportController{

    @GetMapping(value ="/home")
    public String Home() {
        return "Home.html";

    }

    @GetMapping(value = "/newUser")
    public String newUser() {
        return "newUser.html";
    }


    @Autowired
    AirportService airportService;

    @GetMapping(value = "/addUser")
    public String addUserEntry(AirportModel entry){
         airportService.addUser(entry);
         return "Home.html";
    }

    @GetMapping(value = "/logIn")
    public String logIn() {
        return "logIn.html";
    }

    @Autowired
    AirportService airportService2;

    @GetMapping(value="login")
    public String firstPageentry(AirportModel entry) {
        airportService.logIn(entry);
        return "logIn.html";
    }
    
 

}


    



