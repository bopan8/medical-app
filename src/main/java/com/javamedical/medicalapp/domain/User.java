package com.javamedical.medicalapp.domain;

public interface User {

    public void setId(Integer id);

    public  Integer getId();

    public void setName(String name);

    public  String getName();
    public void setPassword(String password);
    public String getPassword();

    public String getRole();
}
