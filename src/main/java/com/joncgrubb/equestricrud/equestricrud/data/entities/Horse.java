package com.joncgrubb.equestricrud.equestricrud.data.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.joncgrubb.equestricrud.equestricrud.data.common.Gender;

@Entity
@Table(name = "horse")
public class Horse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "foalyear")
    private LocalDate foalYear;

    @Column(name = "equibaselink")
    private String equibaseLink;

    @Column(name = "owner")
    private String owner;

    @Column(name = "trainer")
    private String trainer;

    @Column(name = "jockey")
    private String jockey;

    public Horse() {
        super();
    }

    public Horse(String name, Gender gender, LocalDate foalYear, String equibaselink, String owner, String trainer, String jockey) {
        super();
        this.name = name;
        this.gender = gender;
        this.foalYear = foalYear;
        this.equibaseLink = equibaselink;
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

    public String getName(String name) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender(Gender gender) {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getFoalYear(LocalDate foalYear) {
        return foalYear;
    }

    public void setFoalYear(LocalDate foalYear) {
        this.foalYear = foalYear;
    }

    public String getEquibaselink(String equibaselink) {
        return equibaselink;
    }

    public void setEquibaselink(String equibaselink) {
        this.equibaseLink = equibaselink;
    }

    public String getOwner(String owner) {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTrainer(String trainer) {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getJockey(String jockey) {
        return jockey;
    }

    public void setJockey(String jockey) {
        this.jockey = jockey;
    }
}
