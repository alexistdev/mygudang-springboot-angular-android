package com.alexistdev.mygudang.controller;

import com.alexistdev.mygudang.dto.ResponseData;
import com.alexistdev.mygudang.entity.User;
import com.alexistdev.mygudang.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userservice;

    private String message;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody User user){
        ResponseData<User> responseData = new ResponseData<>();
        try{
            ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
            User userData = userservice.save(user);
            responseData.setData(userData);
            responseData.setMessages(resourceBundle.getString("success"));
            return new ResponseEntity<ResponseData<?>>(responseData, HttpStatus.CREATED);
        }catch (Exception e){
            responseData.setStatus(false);
            responseData.setMessages(e.getMessage());
            return new ResponseEntity<ResponseData<?>>(responseData, HttpStatus.BAD_REQUEST);
        }
    }

//    @GetMapping
//    public Iterable<User> findAll(){
//        return userservice.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public User findOne(@PathVariable("id") Long x){
//        return userservice.findUser(x);
//    }
//
//    @DeleteMapping("/{id}")
//    public void removeOne(@PathVariable("id") Long id){
//        userservice.remove(id);
//    }
//
//    @PutMapping
//    public ResponseEntity<ResponseData<User>> update(@Valid @RequestBody User user, Errors errors){
//        ResponseData<User> responseData = new ResponseData<>();
//        if (errors.hasErrors()) {
//            for(ObjectError error: errors.getAllErrors()){
//                responseData.getMessages().add(error.getDefaultMessage());
//            }
//            responseData.setStatus(false);
//            responseData.setPayload(null);
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
//        }
//        responseData.setStatus(true);
//        responseData.setPayload(userservice.save(user));
//        return ResponseEntity.ok(responseData);
//    }
}
