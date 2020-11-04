package br.com.heroes.heroes.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.heroes.heroes.dao.HeroRepository;
import br.com.heroes.heroes.model.Hero;

@Controller
@RequestMapping(path = "/hero")
public class HeroController {

    @Autowired
    private HeroRepository heroRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewHero(@RequestParam String name) {
        Hero hero = new Hero(name);
        heroRepository.save(hero);
        return "Hero added!";
    }
}