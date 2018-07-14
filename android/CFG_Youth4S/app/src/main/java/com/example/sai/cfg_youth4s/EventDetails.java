package com.example.sai.cfg_youth4s;

/**
 * Created by sai on 14-07-2018.
 */
public class EventDetails {
    private String imageurl;
    private String eventname;
    private String eventlocation;
    private String eventdate;
    private String eventtime;

    public EventDetails()
    {

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

    public EventDetails(String imageurl, String eventname, String eventlocation, String eventdate, String eventtime) {
        this.imageurl = imageurl;
        this.eventname = eventname;
        this.eventlocation = eventlocation;
        this.eventdate = eventdate;
        this.eventtime = eventtime;
    }

    public String getEventlocation() {
        return eventlocation;
    }

    public void setEventlocation(String eventlocation) {
        this.eventlocation = eventlocation;
    }

    public String getEventdate() {
        return eventdate;
    }

    public void setEventdate(String eventdate) {
        this.eventdate = eventdate;
    }

    public String getEventtime() {
        return eventtime;
    }

    public void setEventtime(String eventtime) {
        this.eventtime = eventtime;
    }
}
