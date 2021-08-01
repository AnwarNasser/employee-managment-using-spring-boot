/* package com.example.Employee.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping()
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    @GetMapping()
    public List<User> getAllUser(){return userService.getAllUser();}
    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user,@PathVariable int id){
        return userService.updateUser(user,id);
    }
    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }







}*/
