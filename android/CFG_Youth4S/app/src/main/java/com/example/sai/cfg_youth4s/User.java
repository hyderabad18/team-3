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
    private String event;

    public User()
    {
        name = "";
        dob="";
        gender="";
        location="";
        hours="";
        event="";
    }


    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public User(String name, String dob, String gender, String location, String hours, String event) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.location = location;
        this.hours = hours;
        this.event=event;
    }

    public User(String name, String dob, String gender, String location, String hours) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.location = location;
        this.hours = hours;
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

}
