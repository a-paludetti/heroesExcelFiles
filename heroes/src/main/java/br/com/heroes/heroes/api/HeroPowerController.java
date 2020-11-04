package br.com.heroes.heroes.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.heroes.heroes.dao.HeroPowerRepository;
import br.com.heroes.heroes.dao.HeroRepository;
import br.com.heroes.heroes.dao.PowerRepository;
import br.com.heroes.heroes.model.Hero;
import br.com.heroes.heroes.model.HeroPower;
import br.com.heroes.heroes.model.Power;

@Controller
@RequestMapping(path = "/combine-power")
public class HeroPowerController {
    @Autowired
    private HeroPowerRepository repository;

    @Autowired
    private HeroRepository heroRepository;

    @Autowired
    private PowerRepository powerRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String combineHeroToPower(@RequestParam String heroName, @RequestParam String powerName) {
        HeroPower heroPower = new HeroPower();
        Hero hero = heroRepository.findHeroByName(heroName);
        Power power = powerRepository.findPowerByName(powerName);

        heroPower.setHeroId(hero);
        heroPower.setPowerId(power);

        repository.save(heroPower);

        return "Set " + heroName + "'s power to " + powerName;
    }
}
