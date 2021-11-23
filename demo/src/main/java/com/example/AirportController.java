package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;



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

        String password = entry.getPassword();

        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

        entry.setPassword(hashed);


        System.out.println("My password: "+ entry.getPassword());

         airportService.addUser(entry);
         return "Home.html";
    }

    @GetMapping(value = "/login")
    public String logInPage() {
        return "logInPage.html";
    }



    @GetMapping(value="/loginUser")
    public String loginUser(AiportUser user) {

        //user: username; password (need to be hashed) (in login page)

        //List, contains all users data
        List<AirportModel> Users = airportService.getUsers();

        // data created from user create page 
        // Users = [com.example.AirportModel@7569c46c, com.example.AirportModel@64096f90]


        // for (Users user : users)  just an example

        // if(compare){
        //     return "UserHomePage.html";
        // }
    

        // airportService.logIn(entry);

        

        return "UserDoesNotExist.hmtl";
        
    }

    // @GetMapping(value="/UserHomePage")
    // public String UserHomePage(){
    //     return "UserHomePage.html";
    // }
    
 

}


    



