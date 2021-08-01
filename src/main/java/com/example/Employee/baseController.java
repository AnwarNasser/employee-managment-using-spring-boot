package com.example.Employee;

import com.example.Employee.JWT.MyUserDetails;
import org.aspectj.bridge.Message;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


public abstract class baseController {

    public UserDetails getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       return (UserDetails) auth.getPrincipal();
    }


   /* public UserDetails getCurrentUser() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetails) auth.getPrincipal();
    }*/
}
