package br.com.heroes.heroes.dao;

import org.springframework.data.repository.CrudRepository;
import br.com.heroes.heroes.model.Hero;

public interface HeroRepository extends CrudRepository<Hero, Integer>{
    Hero findHeroByName(String name);
}