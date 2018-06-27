package com.nz.springbootlearning.reflection;

public class Pig {

    private  String pigName;
    private  String pigAge;
    private String weight;

    public Pig(String pigName, String pigAge, String pigWeight) {
        this.pigName = pigName;
        this.pigAge = pigAge;
        this.weight = pigWeight;
    }
    public  Pig(){
        System.out.println("Pig Constructor");
    }

    public String getPigName() {
        return pigName;
    }

    public void setPigName(String pigName) {
        this.pigName = pigName;
    }

    public String getPigAge() {
        return pigAge;
    }

    public void setPigAge(String pigAge) {
        this.pigAge = pigAge;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
