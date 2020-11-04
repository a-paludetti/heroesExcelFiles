package br.com.heroes.heroes.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.heroes.heroes.dao.PowerRepository;
import br.com.heroes.heroes.model.Power;

@Controller
@RequestMapping(path = "/power")
public class PowerController {
    @Autowired
    private PowerRepository powerRepository;

    @PostMapping(path = "/add")
    public @RequestMapping String addNewPower(@RequestParam String powerName){
        Power power = new Power(powerName);
        powerRepository.save(power);

        return "Power saved!";
    }
}
