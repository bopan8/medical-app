package com.javamedical.medicalapp.detailService;

import com.javamedical.medicalapp.domain.Patient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PatientUserDetails implements UserDetails {

    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    public PatientUserDetails(Patient patient){
        this.username = patient.getName();
        this.password = "{noop}"+patient.getPassword();
        this.authorities = Arrays.stream(patient.getRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        //debug sout
        System.out.println("patient");
        System.out.println(this.username);
        System.out.println(this.password);
        for (GrantedAuthority authority:authorities) {
            System.out.println(authority.getAuthority());
        }
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {return authorities;}

    @Override
    public String getPassword() {return this.password;}

    @Override
    public String getUsername() {return this.username;}

    @Override
    public boolean isAccountNonExpired() { return true;}

    @Override
    public boolean isAccountNonLocked() {return true;}

    @Override
    public boolean isCredentialsNonExpired() {return true;}

    @Override
    public boolean isEnabled() { return true;}
}
