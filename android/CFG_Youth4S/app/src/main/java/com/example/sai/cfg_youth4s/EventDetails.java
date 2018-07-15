package com.example.sai.cfg_youth4s;

import java.util.ArrayList;

/**
 * Created by sai on 14-07-2018.
 */
public class EventDetails extends ArrayList<EventDetails>{
    private String imageurl;
    private String eventname;
    private String eventlocation;
    private String startdate;
    private String starttime;
    private String enddate;
    private String eventdesc;

    public EventDetails() {

    }

    public EventDetails(String imageurl, String eventname, String eventlocation, String startdate, String starttime, String enddate, String eventdesc) {
        this.imageurl = imageurl;
        this.eventname = eventname;
        this.eventlocation = eventlocation;
        this.startdate = startdate;
        this.starttime = starttime;
        this.enddate = enddate;
        this.eventdesc = eventdesc;
    }

    public EventDetails(String imageurl, String eventname, String eventlocation, String startdate, String starttime) {
        this.imageurl  = imageurl;
        this.eventname = eventname;
        this.eventlocation = eventlocation;
        this.startdate = startdate;
        this.starttime = starttime;

    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getEventlocation() {
        return eventlocation;
    }

    public void setEventlocation(String eventlocation) {
        this.eventlocation = eventlocation;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getEventdesc() {
        return eventdesc;
    }

    public void setEventdesc(String eventdesc) {
        this.eventdesc = eventdesc;
    }
}