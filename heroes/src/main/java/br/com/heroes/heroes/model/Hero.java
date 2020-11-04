package br.com.heroes.heroes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Hero")
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Hero(String name){
        this.name = name;
    }

    public Hero(){}

    /** Gettes & Setters **/
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Long getId(){
        return id;
    }
}