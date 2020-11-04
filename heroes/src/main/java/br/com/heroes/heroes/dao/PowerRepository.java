package br.com.heroes.heroes.dao;

import org.springframework.data.repository.CrudRepository;
import br.com.heroes.heroes.model.Power;

public interface PowerRepository extends CrudRepository<Power, Integer>{
    Power findPowerByName(String name);
}