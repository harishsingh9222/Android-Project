package com.harish.xdev.parking.Model;

public class AddTicket {
    private  int id;
    private  String etdate;

    private String vnumber;
    private String vbrand;
    private String vcolor;
    private String position;
    private String lane;
    private String paymethod;
    private String time;

    public AddTicket() {

    }

    public AddTicket(int id,String etdate, String vnumber, String vbrand, String vcolor, String position, String lane, String paymethod, String time) {
        this.id = id;
        this.etdate=etdate;
        this.vnumber = vnumber;
        this.vbrand = vbrand;
        this.vcolor = vcolor;
        this.position = position;
        this.lane = lane;
        this.paymethod = paymethod;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setEtdate(String etdate) {
        this.etdate = etdate;
    }
    public String getVnumber() {
        return vnumber;
    }
    public String getEtdate() {
        return etdate;
    }

    public void setVnumber(String vnumber) {
        this.vnumber = vnumber;
    }

    public String getVbrand() {
        return vbrand;
    }

    public void setVbrand(String vbrand) {
        this.vbrand = vbrand;
    }

    public String getVcolor() {
        return vcolor;
    }

    public void setVcolor(String vcolor) {
        this.vcolor = vcolor;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public String getPaymethod() {
        return paymethod;
    }

    public void setPaymethod(String paymethod) {
        this.paymethod = paymethod;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}