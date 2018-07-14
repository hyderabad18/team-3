package com.example.sai.cfg_youth4s;

import java.util.ArrayList;

/**
 * Created by sai on 15-07-2018.
 */
public class User extends ArrayList<User>{
    private String name;
    private String dob;
    private String gender;
    private String location;
    private String hours;
    private String completed;
    private String pending;
    private String ongoing;

    public User()
    {
        name = "";
        dob="";
        gender="";
        location="";
        hours="";
        completed="";
        pending="";
        ongoing="";
    }


    public User(String name, String dob, String gender, String location, String hours, String completed, String pending, String ongoing) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.location = location;
        this.hours = hours;
        this.completed = completed;
        this.pending = pending;
        this.ongoing = ongoing;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public String getPending() {
        return pending;
    }

    public void setPending(String pending) {
        this.pending = pending;
    }

    public String getOngoing() {
        return ongoing;
    }

    public void setOngoing(String ongoing) {
        this.ongoing = ongoing;
    }
}
