package com.example.Employee.JWT;

//import com.example.Employee.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUserName(String userName);
   /* @Query(value = "select * from User",nativeQuery = true)
    Optional<List<User>> getAllUsers();*/


}