package com.example.Nazmus_Sakib_Ohee.digital_doctor;

public class DataModel {

    private String name ;
    private String spaciality ;
    private String designation ;
    private String chamber;
    private String duration;
    private String offday ;
    private String id ;

    public DataModel(String name, String spaciality, String designation, String chamber, String duration, String offday, String id) {
        this.name = name;
        this.spaciality = spaciality;
        this.designation = designation;
        this.chamber = chamber;
        this.duration = duration;
        this.offday = offday;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpaciality() {
        return spaciality;
    }

    public void setSpaciality(String spaciality) {
        this.spaciality = spaciality;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getChamber() {
        return chamber;
    }

    public void setChamber(String chamber) {
        this.chamber = chamber;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getOffday() {
        return offday;
    }

    public void setOffday(String offday) {
        this.offday = offday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
