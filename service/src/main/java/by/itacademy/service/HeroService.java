package by.itacademy.service;

import by.itacademy.entity.Hero;
import by.itacademy.entity.HeroAbility;
import by.itacademy.entity.other.HeroRole;
import by.itacademy.service.common.BaseService;

import java.util.List;

public interface HeroService extends BaseService<Hero> {

    List<HeroAbility> getAllAbilities(Long primaryKey);

    Hero changeName(Hero hero, String name);

    Hero changeRole(Hero hero, HeroRole heroRole);

    Hero changePicture(Hero hero, String srcPicture);

    Hero getByName(String name);
}
