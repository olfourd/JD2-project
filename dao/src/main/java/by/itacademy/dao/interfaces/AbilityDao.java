package by.itacademy.dao.interfaces;

import by.itacademy.entity.common.HeroAbility;

public interface AbilityDao extends BaseDao<HeroAbility> {
    HeroAbility changeName(HeroAbility ability, String name);

    HeroAbility changePicture(HeroAbility ability, String src);

    HeroAbility changeVideo(HeroAbility ability, String src);

    HeroAbility getByName(String name);
}
