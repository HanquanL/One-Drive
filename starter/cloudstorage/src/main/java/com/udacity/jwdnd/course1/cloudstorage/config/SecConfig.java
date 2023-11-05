package com.udacity.jwdnd.course1.cloudstorage.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration // This annotation tells Spring Boot that this is a configuration class.
@EnableWebSecurity // This annotation tells Spring Boot to enable web security.
public class SecConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests()
               .antMatchers("/signup", "/css/**", "/js/**").permitAll()
                .anyRequest().authenticated();

       http.formLogin()
               .loginPage("/login")
               .permitAll();

       http.formLogin()
                .defaultSuccessUrl("/home", true);
    }
}
