/*package com.example.Employee.User;

import com.example.Employee.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ConvertService convertService;

   /* public List<SecurityConfiguration.UserViewDto> getAllUsers()
    {
       List<User> users = userRepository.getAllUsers().orElse(new ArrayList<>());
       return users.stream().map(convertService::convertUserToDto).collect(Collectors.toList());
    }
    public User getUserByUserName(String userName){
        return userRepository.findByUserName(userName).orElseThrow(()->new ResourceNotFoundException(" not found"  +userName));
    }*/
    /* public SecurityConfiguration.UserViewDto saveUser(SecurityConfiguration.UserSaveDto userSaveDto){
        userSaveDto.setActive(true);
        return userRepository.save(userSaveDto);
    }*/
   /* public User updateUser(int id,User user){
        User old = userRepository.findById(id).get();
        old.setUserName(user.getUserName());
        old.setPassword(user.getPassword());
        old.setRoles(user.getRoles());
        old.setActive(user.getActive());
        return old;
    }
    public User deleteUser(int id,User user){
        User old=userRepository.findById(id).get();
        old.setActive(false);
        return old;
    }*/
  /* public userViewDto saveUser(userSaveDto userSaveDto){
       userSaveDto.setActive(true);
       return userRepository.save(userSaveDto);
   }*/
 /* public User saveUser(User user){
     // user.setActive(true);
      return userRepository.save(user);
  }
  public List<User> getAllUser(){
     List<User> users =  userRepository.findAll();
     return users;
  }
  public User updateUser(User user,int id){
      User old = userRepository.findById(id).get();
      old.setUserName(user.getUserName());
      old.setPassword(user.getPassword());
      old.setActive(true);
      old.setRoles(user.getRoles());
      return userRepository.save(old);
  }
  public User deleteUser(int id){
      User old = userRepository.findById(id).get();
      old.setActive(false);
      return old;
  }
}
*/