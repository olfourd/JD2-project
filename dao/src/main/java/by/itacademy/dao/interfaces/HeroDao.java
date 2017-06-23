package by.itacademy.dao.interfaces;

import by.itacademy.entity.common.Hero;
import by.itacademy.entity.common.HeroAbility;
import by.itacademy.entity.other.HeroRole;

import java.util.List;

public interface HeroDao extends BaseDao<Hero> {

    List<HeroAbility> getAllAbilities(Long primaryKey);

    Hero changeName(Hero hero, String name);

    Hero changeRole(Hero hero, HeroRole heroRole);

    Hero changePicture(Hero hero, String srcPicture);

    Hero getByName(String name);
}
