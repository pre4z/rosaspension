package org.example.dog;


public class Dog {


    private int dogID;
    private String name;
    private int age;
    private String race;
    private String specialNeeds;
    private String preferredVet;
    private double weight;
    private int expectedStay;
    private int feedingFreq;
    private int foodInGrams;


    public Dog(String name, int age, String race, String specialNeeds, String preferredVet, double weight) {
        this.name = name;
        this.age = age;
        this.race = race;
        this.specialNeeds = specialNeeds;
        this.preferredVet = preferredVet;
        this.weight = weight;
    }
    public Dog() {}

    public int getDogID() {
        return dogID;
    }

    public void setDogID(int dogID) {
        this.dogID = dogID;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getRace() {
        return race;
    }
    public void setRace(String race) {
        this.race = race;
    }
    public String getSpecialNeeds() {
        return specialNeeds;
    }
    public void setSpecialNeeds(String specialNeeds) {
        this.specialNeeds = specialNeeds;
    }
    public String getPreferredVet() {
        return preferredVet;
    }
    public void setPreferredVet(String preferredVet) {
        this.preferredVet = preferredVet;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }



}
