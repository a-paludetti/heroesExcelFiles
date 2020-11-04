package br.com.heroes.heroes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HeroPower")
public class HeroPower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long heroId;

    private Long powerId;

    public HeroPower(){}

    /**  Getters && Setters   **/
    public void setHeroId(Hero hero){
        this.heroId = hero.getId();
    }

    public Long getHeroId(){
        return heroId;
    }

    public void setPowerId(Power power){
        this.powerId = power.getId();
    }

    public Long getPowerId(){
        return powerId;
    }
}