package com.example.Employee.JWT;

import com.example.Employee.Dto.userSaveDto;
import com.example.Employee.JWT.MyUserDetails;
//import com.example.Employee.User.User;
import com.example.Employee.JWT.UserRepository;
import com.example.Employee.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder bcryptEncoder;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user=userRepository.findByUserName(userName);
        user.orElseThrow(()-> new UsernameNotFoundException("not found :"  +userName));
        return user.map(MyUserDetails::new ).get();
    }
    public User save(userSaveDto userSaveDto){
        User newUser = new User();
        newUser.setUserName(userSaveDto.getUserName());
        newUser.setPassword(bcryptEncoder.encode(userSaveDto.getPassword()));
        newUser.setActive(true);
        //newUser.setRoles(userSaveDto.getRoles());
        return userRepository.save(newUser);
    }
    public List<User> getAllUser(){
        List<User> users =userRepository.findAll();
        return users;
    }
   /* public User getUserByName(String userName){
        return userRepository.findByUserName(userName).orElseThrow(()->new ResourceNotFoundException(" not found"  +userName));
    }*/
    public User updateUser(User user,int id){
        User upUser = userRepository.findById(id).get();
        upUser.setUserName(user.getUserName());
        upUser.setPassword(user.getPassword());
       // upUser.setRoles(user.getRoles());
        upUser.setActive(user.getActive());
        return userRepository.save(upUser);
    }
    public User deleteUser(User user,int id){
        User user1=userRepository.findById(id).get();
        user1.setActive(false);
        return userRepository.save(user1);
    }


}
