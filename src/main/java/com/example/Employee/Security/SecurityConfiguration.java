/*package com.example.Employee.Security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;
    @Autowired
   UserDetailsService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
     auth.userDetailsService(userDetailsService);
       /* auth.jdbcAuthentication()
                .dataSource(dataSource);*/
// }

   /* configure Authentication in memory
   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("Anwar")
                .password("Anwar")
                .roles("USER")
                .and()
                .withUser("foo")
                .password("foo")
                .roles("ADMIN");
    }*/
   /* @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/login").hasAnyRole("USER","ADMIN") // take /login as url on method printUser to get currentUser
                .antMatchers("/admin").hasRole("ADMIN") // take /admin as url on method to get   صلاحيات المدير
                .antMatchers("/user").hasAnyRole("USER","ADMIN") // take /user as url on method to get صلاحيات المستخدمين وبنفس الوقت المدير
                .antMatchers("/").permitAll()
                .and().formLogin();
    }*/


    /* @Bean
    public ChildRepository childRepositoryBean() throws Exception{
        return childRepositoryBean();
    }*/
  /*  @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserSaveDto {
        private String userName;
        private String password;
        private Boolean active;
        private String roles;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserViewDto {
        private int userId;
        private String userName;
        private String password;
        private String roles;
        private boolean active;
    }
}
*/