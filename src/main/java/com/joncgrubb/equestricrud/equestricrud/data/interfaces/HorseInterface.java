package com.joncgrubb.equestricrud.equestricrud.data.interfaces;

public class HorseInterface {

    private long id;

    private String name;

    private String genderName;

    private String age;

    private String equibaselink;

    private String owner;

    private String trainer;

    private String jockey;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEquibaselink() {
        return equibaselink;
    }

    public void setEquibaselink(String equibaselink) {
        this.equibaselink = equibaselink;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getJockey() {
        return jockey;
    }

    public void setJockey(String jockey) {
        this.jockey = jockey;
    }
}
