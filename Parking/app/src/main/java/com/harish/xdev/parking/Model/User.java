package com.harish.xdev.parking.Model;

import android.widget.EditText;
import android.widget.TextView;

public class User {
    EditText name;
    EditText vehicle;
    EditText newpass;
    EditText ph;

    public User(EditText name, EditText vehicle, EditText newpass, EditText ph) {
        this.name = name;
        this.vehicle = vehicle;
        this.newpass = newpass;
        this.ph = ph;
    }

    public EditText getName() {
        return name;
    }

    public void setName(EditText name) {
        this.name = name;
    }

    public EditText getVehicle() {
        return vehicle;
    }

    public void setVehicle(EditText vehicle) {
        this.vehicle = vehicle;
    }

    public EditText getNewpass() {
        return newpass;
    }

    public void setNewpass(EditText newpass) {
        this.newpass = newpass;
    }

    public EditText getPh() {
        return ph;
    }

    public void setPh(EditText ph) {
        this.ph = ph;
    }
}
