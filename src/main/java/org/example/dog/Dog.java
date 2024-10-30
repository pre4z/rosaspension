package org.example.dog;


public class Dog {


    private int dogID;
    private String name;
    private int age;
    private String race;
    private String specialNeeds;
    private String preferredVet;
    private float weight;
    private int expectedStay;
    private int userID;
    private int foodID;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }


    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }


    public int getFeedingFreq() {
        return feedingFreq;
    }

    public void setFeedingFreq(int feedingFreq) {
        this.feedingFreq = feedingFreq;
    }

    private int feedingFreq;

    public int getFoodInGrams() {
        return foodInGrams;
    }

    public void setFoodInGrams(int foodInGrams) {
        this.foodInGrams = foodInGrams;
    }

    private int foodInGrams;


    public Dog(int dogID, String name, int age, String race, String specialNeeds, String preferredVet, float weight, int expectedStay, int foodInGrams, int userID, int foodID) {
        this.dogID = dogID;
        this.name = name;
        this.age = age;
        this.race = race;
        this.specialNeeds = specialNeeds;
        this.preferredVet = preferredVet;
        this.weight = weight;
        this.expectedStay = expectedStay;
        this.userID = userID;
        this.foodInGrams = foodInGrams;
        this.foodID = foodID;


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
    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }
    public int getExpectedStay() {
        return expectedStay;
    }

    public void setExpectedStay(int expectedStay) {
        this.expectedStay = expectedStay;
    }



}
