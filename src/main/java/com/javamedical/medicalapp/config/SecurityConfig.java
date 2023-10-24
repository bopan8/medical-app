package com.javamedical.medicalapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    AuthenticationSuccessHandler authenticationSuccessHandler;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
                .csrf().disable()
                .authorizeHttpRequests(auth ->{
                    auth.requestMatchers("/",
                            "/register",
                            "/webjars/**",
                            "/downloadReceipt",
                            "/active",
                            "/assets/**").permitAll();
                    auth.requestMatchers("/patient").hasAuthority("PATIENT");
                    auth.requestMatchers("/doctor").hasAuthority("DOCTOR");
                    auth.requestMatchers("/secured").authenticated();
                    auth.anyRequest().authenticated();
                })
                .oauth2Login(oauth2 -> oauth2
                        .defaultSuccessUrl("/secured")
                )
                .formLogin(formLogin -> formLogin
                        .successHandler(authenticationSuccessHandler) // Use the custom success handler
                        .permitAll())
                .logout()
                .logoutUrl("/logout") // Customize the logout URL if needed
                .logoutSuccessUrl("/") // Redirect to the main page after logout
                .permitAll(); // Allow anyone to access the logout URL

        return http.build();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

}