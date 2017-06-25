package by.itacademy.service;

import by.itacademy.dao.HeroDaoImpl;
import by.itacademy.entity.Hero;
import by.itacademy.entity.HeroAbility;
import by.itacademy.entity.other.HeroRole;
import by.itacademy.service.common.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HeroServiceImpl extends BaseServiceImpl<Hero, HeroDaoImpl> implements HeroService{

    @Override
    public List<HeroAbility> getAllAbilities(Long primaryKey) {
        return getRepository().getAllAbilities(primaryKey);
    }

    @Override
    public Hero changeName(Hero hero, String name) {
        return getRepository().changeName(hero, name);
    }

    @Override
    public Hero changeRole(Hero hero, HeroRole heroRole) {
        return getRepository().changeRole(hero, heroRole);
    }

    @Override
    public Hero changePicture(Hero hero, String srcPicture) {
        return getRepository().changePicture(hero, srcPicture);
    }

    @Override
    public Hero getByName(String name) {
        return getRepository().getByName(name);
    }
}
