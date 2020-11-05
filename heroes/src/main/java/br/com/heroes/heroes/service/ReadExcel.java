package br.com.heroes.heroes.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.heroes.heroes.dao.HeroPowerRepository;
import br.com.heroes.heroes.dao.HeroRepository;
import br.com.heroes.heroes.dao.PowerRepository;
import br.com.heroes.heroes.model.Hero;
import br.com.heroes.heroes.model.HeroPower;
import br.com.heroes.heroes.model.Power;

public class ReadExcel {

    @Autowired
    private static HeroRepository heroRepository;

    @Autowired
    private static PowerRepository powerRepository;

    @Autowired
    private static HeroPowerRepository heroPowerRepository;

    public static void main(String[] args) {
        try {
            FileInputStream file = new FileInputStream(new File("heroes.xlsx"));

            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                System.out.println(row.getRowNum() + 1);
                int i = 0;
                HeroPower hp = new HeroPower();
                for (Cell cell : row) {
                    if (row.getRowNum() != 0) {
                        switch (i) {
                            case 0:
                                createHero(cell.getStringCellValue());
                                hp.setHeroId(heroRepository.findHeroByName(cell.getStringCellValue()));
                                i++;
                                break;
                            case 1:
                                createPower(cell.getStringCellValue());
                                hp.setPowerId(powerRepository.findPowerByName(cell.getStringCellValue()));
                                i++;
                                break;
                        }
                        heroPowerRepository.save(hp);
                    }
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void createHero(String name) {
        try {
            Hero hero = heroRepository.findHeroByName(name);
            System.out.println(hero.getName() + " already exists.");
        } catch (NullPointerException n) {
            Hero hero = new Hero(name);
            heroRepository.save(hero);
        }

    }

    public static void createPower(String name) {
        try {
            Power power = powerRepository.findPowerByName(name);
            System.out.println(power.getName() + " already exists.");
        } catch (NullPointerException n) {
            Power power = new Power(name);
            powerRepository.save(power);
        }
    }
}
