package br.com.heroes.heroes.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.heroes.heroes.model.HeroPower;

public interface HeroPowerRepository extends CrudRepository<HeroPower, Integer>{
}