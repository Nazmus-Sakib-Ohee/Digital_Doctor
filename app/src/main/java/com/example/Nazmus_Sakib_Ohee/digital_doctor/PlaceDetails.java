package com.example.Nazmus_Sakib_Ohee.digital_doctor;

/**
 * Created by Nazmus_Sakib_Ohee on 11/16/2017.
 */

public class PlaceDetails {
    private String lan;
    private String lat;
    private String longName = "-NA-";
    private String shortName = "-NA-";
    private String address = "-NA-";
    private String reference = "-NA-";
    private String icon = "-NA-";
    private String phoneNumber = "-NA-";
    private String vicinity = "-NA-";

    private String placeName;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Double getLan() {
        return Double.parseDouble(lan);
    }

    public void setLan(String lan) {
        this.lan = lan;
    }

    public Double getLat() {
        return Double.parseDouble(lat);
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
