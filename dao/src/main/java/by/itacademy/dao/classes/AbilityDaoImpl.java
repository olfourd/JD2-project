package by.itacademy.dao.classes;

import by.itacademy.dao.interfaces.AbilityDao;
import by.itacademy.entity.common.HeroAbility;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AbilityDaoImpl extends BaseDaoImpl<HeroAbility> implements AbilityDao{
    @Override
    public HeroAbility changeName(HeroAbility ability, String name) {
        ability.setName(name);
        return update(ability);
    }

    @Override
    public HeroAbility changePicture(HeroAbility ability, String src) {
        ability.setPassToImg(src);
        return update(ability);
    }

    @Override
    public HeroAbility changeVideo(HeroAbility ability, String src) {
        ability.setPassToVideo(src);
        return update(ability);
    }

    @Override
    public HeroAbility getByName(String name) {
        return getSessionFactory()
                .getCurrentSession()
                .createQuery("select a from HeroAbility a where a.name=:abilityName", HeroAbility.class)
                .setParameter("abilityName", name)
                .getSingleResult();
    }
}
