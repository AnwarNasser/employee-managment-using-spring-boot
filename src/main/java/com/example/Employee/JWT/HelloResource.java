package com.example.Employee.JWT;

import com.example.Employee.Dto.userSaveDto;
import javassist.bytecode.stackmap.BasicBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Cache;
import java.util.List;

@RestController
@RequestMapping("/public")
public class HelloResource {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    jwtUtil jwtTokenUtil;

    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("IncorrectUsername or password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername
                (authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
    @PostMapping("/register")
    public User register(@RequestBody userSaveDto userSaveDto){

        return userDetailsService.save(userSaveDto);
    }
    @GetMapping("/all")
    public List<User> getAllUser(){
        return userDetailsService.getAllUser();
    }
    @GetMapping("/{userName}")
    public UserDetails  getUserByName(@PathVariable String userName ){
       return  userDetailsService.loadUserByUsername(userName);
    }
    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user,@PathVariable int id){
        return userDetailsService.updateUser(user,id);
    }
    @DeleteMapping("/{id}")
    public User deleteUser(@RequestBody User user,@PathVariable int id){
        return userDetailsService.deleteUser(user,id);
    }
    // كيف اذا كان اليوزر ِactive =0  كيف مانسمح له بالدخول للنظام
    // لما اضيف يوزر جديد والرول حقي تابته متلا كيف اضيفه !! هل احط فاليديشن انه كله الحروف كبتل ليتر وانه بغير الي معانا الي بالاكواد مايسمح بالأضافه
}