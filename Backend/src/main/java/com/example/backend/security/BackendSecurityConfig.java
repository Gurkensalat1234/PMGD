package com.example.backend.security;

import com.example.backend.general.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Profile("!production")
@EnableWebSecurity
@Configuration
public class BackendSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String READ_AUTHORITY = "READ_PRIVILEGE";
    private static final String WRITE_AUTHORITY = "WRITE_PRIVILEGE";
    private static final String DELETE_AUTHORITY = "DELETE_PRIVILEGE";

    private static final UserDetails admin = User
            .withUsername("admin")
            .password("{noop}admin")
            .authorities(READ_AUTHORITY, WRITE_AUTHORITY, DELETE_AUTHORITY)
            .build();

    // Set password storage format to noop (plain text)
    private static final UserDetails read = User
            .withUsername("read")
            .password("{noop}read")
            .authorities(READ_AUTHORITY)
            .build();
    private static final UserDetails write = User
            .withUsername("write")
            .password("{noop}write")
            .authorities(WRITE_AUTHORITY)
            .build();

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable()
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(Constants.REST_API_BASE_URL + "/test").permitAll()
                .antMatchers(Constants.REST_API_FILE_ENDPOINT + "/**").hasAuthority(WRITE_AUTHORITY);
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser(admin).withUser(read).withUser(write);
    }
}
