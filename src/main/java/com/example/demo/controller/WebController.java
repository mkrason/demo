package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    UserRepository repository;

    @RequestMapping("/save")
    public String process() {
        repository.save(new User("Jack", "Smith", "mylogin", "secret", 1));
        repository.save(new User("Jack2", "Smith2", "mylogin2", "secret", 1));
        repository.save(new User("Jack3", "Smith3", "mylogin3", "secret", 1));
        return "Done";

    }

    @RequestMapping("/findall")
    public String findAll(){

        String result = "<html>";

        for (User user : repository.findAll()){
            result += "<div>" + user.toString() + "</div>";
        }
        return result + "</html>";
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id){
        String result = "";
        result = repository.findById(id).toString();
        return result;
    }

    @RequestMapping("/findbylastname")
    public String fetchDataByLastName(@RequestParam("lastname") String lastName){
        String result = "<html>";

        for(User user: repository.findByLastName(lastName)){
            result += "<div>" + user.toString() + "</div>";
        }

        return result + "</html>";
    }

}

