/*package com.example.Employee.Security;

import com.example.Employee.User.UserService;
import com.example.Employee.User.User;
import com.example.Employee.User.userViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class HomeRequest {
    @Autowired
    MyUserDetailsService myUserDetailsService;
    UserService userService;
    //@PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping()
    public String home(){
        return ("<h1>Welcome<h1>");
    }
   /* @GetMapping("/user")
    public String user(){
        return ("<h1>Welcome user<h1>");
    }
    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Welcome admin<h1>");
    }*/
   /* @GetMapping("/{userName}")
    public UserDetails loadUserByUsername(@PathVariable String userName){
        return myUserDetailsService.loadUserByUsername(userName);
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String printUser(ModelMap model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); // get logged in username
        model.addAttribute("username",name);
        return "hello" + " "+  name;
    }
   /* @PostMapping()
    public userViewDto saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }*/
   /* @RequestMapping(value = "/login",method = RequestMethod.GET)
    public static Optional<User> currentUser(Authentication auth){
        Authentication authen =SecurityContextHolder.getContext().getAuthentication();
        String username =authen.getName();
        if(auth != null){
            Object principal = auth.getPrincipal();
            if( principal instanceof User) // User is your user type that implements UserDetails
                return Optional.of((User) principal);
        }
        return Optional.empty();
    }*/
 /* @RequestMapping(value = "/login",method = RequestMethod.GET)
   private String getPrincipal(){
       String userName =null;
       Object principal =SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       if(principal instanceof UserDetails){
           userName= ((UserDetails) principal).getUsername();
       }
       else {
           userName=principal.toString();
       }
       return userName;
   }*/

// }
