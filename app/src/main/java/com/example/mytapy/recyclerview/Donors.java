package com.example.mytapy.recyclerview;

import java.util.ArrayList;

/**
 * Created by mytapy on 18/06/17.
 */

public class Donors {
    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private String mobile;
    private String bloodGroup;
    private String age;
    private String gender;
    private String country;
    private String location;
    private String latitude;
    private String longitude;
    private String profilePicName;
    private String profilePicURL;

    private ArrayList<Donors> donorsList;

    public Donors(String firstName, String secondName, String email, String password,
                  String mobile, String bloodGroup, String age, String gender, String country,
                  String location, String latitude, String longitude, String profilePicName, String profilePicURL) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.bloodGroup = bloodGroup;
        this.age = age;
        this.gender = gender;
        this.country = country;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.profilePicName = profilePicName;
        this.profilePicURL = profilePicURL;
    }

    public Donors(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getProfilePicName() {
        return profilePicName;
    }

    public void setProfilePicName(String profilePicName) {
        this.profilePicName = profilePicName;
    }

    public String getProfilePicURL() {
        return profilePicURL;
    }

    public void setProfilePicURL(String profilePicURL) {
        this.profilePicURL = profilePicURL;
    }
}
