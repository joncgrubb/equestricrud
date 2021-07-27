package com.joncgrubb.equestricrud.equestricrud.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.joncgrubb.equestricrud.equestricrud.data.common.Gender;

@Entity
@Table(name = "horse")
public class Horse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @NotNull
    @Column(name = "foalyear")
    private int foalYear;

    @NotNull
    @Column(name = "equibaselink")
    private String equibaselink;

    @NotNull
    @Column(name = "owner")
    private String owner;

    @NotNull
    @Column(name = "trainer")
    private String trainer;

    @NotNull
    @Column(name = "jockey")
    private String jockey;

    public Horse() {
        super();
    }

    public Horse(String name, Gender gender, int foalYear, String equibaselink, String owner, String trainer,
            String jockey) {
        super();
        this.name = name;
        this.gender = gender;
        this.foalYear = foalYear;
        this.equibaselink = equibaselink;
        this.owner = owner;
        this.trainer = trainer;
        this.jockey = jockey;
    }

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getFoalYear() {
        return foalYear;
    }

    public void setFoalYear(int foalYear) {
        this.foalYear = foalYear;
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