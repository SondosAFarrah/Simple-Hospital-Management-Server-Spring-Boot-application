package com.example.demo.models;

import java.util.ArrayList;

public class Patient {
    private Long id;
    private String name;
    private double illnessExperienceRequirement;
    private Boolean isCured;
    private ArrayList<Long> doctors;

    // Default constructor
    public Patient() {
        super();
        this.isCured = false; // Initially false
        this.doctors = new ArrayList<>(); // Initialize the doctors list
        // TODO Auto-generated constructor stub
    }

    // Parameterized constructor
    public Patient(Long id, String name, double illnessExperienceRequirement, Boolean isCured, ArrayList<Long> doctors) {
        this.id = id;
        this.name = name;
        this.illnessExperienceRequirement = illnessExperienceRequirement;
        this.isCured = isCured;
        this.doctors = doctors;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIllnessExperienceRequirement() {
        return illnessExperienceRequirement;
    }

    public void setIllnessExperienceRequirement(double illnessExperienceRequirement) {
        this.illnessExperienceRequirement = illnessExperienceRequirement;
    }

    public Boolean getIsCured() {
        return isCured;
    }

    public void setIsCured(Boolean isCured) {
        this.isCured = isCured;
    }

    public ArrayList<Long> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Long> doctors) {
        this.doctors = doctors;
    }

    // Override toString
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", illnessExperienceRequirement=" + illnessExperienceRequirement +
                ", isCured=" + isCured +
                ", doctors=" + doctors +
                '}';
    }

}
