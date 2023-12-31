package com.udacity.jwdnd.course1.cloudstorage.config;

import com.udacity.jwdnd.course1.cloudstorage.services.AuthenticationService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration // This annotation tells Spring Boot that this is a configuration class.
@EnableWebSecurity // This annotation tells Spring Boot to enable web security.
public class SecConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationService authenticationService;

    public SecConfig(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(this.authenticationService);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
               .csrf().disable()
               .cors().and()
                .authorizeRequests()
               .antMatchers("/signup", "/css/**", "/js/**", "/h2-console/**", "/login").permitAll()
               .antMatchers("/note/**", "/file/**").authenticated()
                .anyRequest().authenticated()
               .and().headers().frameOptions().sameOrigin()
               .and().httpBasic();


    }
}
