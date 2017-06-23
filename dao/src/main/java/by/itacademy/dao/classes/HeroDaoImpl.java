package by.itacademy.dao.classes;

import by.itacademy.dao.interfaces.HeroDao;
import by.itacademy.entity.common.Hero;
import by.itacademy.entity.common.HeroAbility;
import by.itacademy.entity.other.HeroRole;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class HeroDaoImpl extends BaseDaoImpl<Hero> implements HeroDao {


    //TODO: не рабочий! реализовать
    @Override
    public List<HeroAbility> getAllAbilities(Long primaryKey) {
        Session session = getSessionFactory().getCurrentSession();
        Hero hero = session.find(Hero.class, primaryKey);
        List<HeroAbility> abilities = hero.getAbilities();
        return abilities;
    }

    @Override
    public Hero changeName(Hero hero, String name) {
        hero.setName(name);
        return update(hero);
    }

    @Override
    public Hero changeRole(Hero hero, HeroRole heroRole) {
        hero.setRole(heroRole);
        return update(hero);
    }

    @Override
    public Hero changePicture(Hero hero, String srcPicture) {
        hero.setPassToPicture(srcPicture);
        return update(hero);
    }

    @Override
    public Hero getByName(String name) {
        Session session = getSessionFactory().getCurrentSession();
        return session.createQuery("select h from Hero h where h.name=:heroName", Hero.class)
                .setParameter("heroName", name)
                .getResultList()
                .get(0);
    }
}
