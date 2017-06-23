package by.itacademy.dao.classes;

import by.itacademy.dao.interfaces.HeroAbilityDao;
import by.itacademy.entity.common.HeroAbility;
import by.itacademy.util.DataImporterToH2;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class HeroAbilityDaoTest extends BaseDaoTest {

    @Autowired
    private HeroAbilityDao heroAbilityDao;
    @Autowired
    private DataImporterToH2 importerToH2;

    @Before
    public void init() {
        importerToH2.importTestData(heroAbilityDao.getSessionFactory().getCurrentSession());
    }

    @Test
    public void getByName() {
        String nameAbility = "Headbutt";
        HeroAbility ability = heroAbilityDao.getByName(nameAbility);
        assertEquals(ability.getName(), nameAbility);
    }

    @Test
    public void changeName() {
        HeroAbility ability = heroAbilityDao.getByName("Headbutt");
        String newName = "QWERTY";
        HeroAbility updatedAbility = heroAbilityDao.changeName(ability, newName);
        assertEquals(updatedAbility.getName(), newName);
    }

    @Test
    public void changePicture() {
        HeroAbility ability = heroAbilityDao.getByName("Headbutt");
        String newPassToPicture = "QWERTY";
        HeroAbility updatedAbility = heroAbilityDao.changePicture(ability, newPassToPicture);
        assertEquals(updatedAbility.getPassToImg(), newPassToPicture);
    }

    @Test
    public void changeVideo() {
        HeroAbility ability = heroAbilityDao.getByName("Headbutt");
        String newPassToVideo = "QWERTY";
        HeroAbility updatedAbility = heroAbilityDao.changeVideo(ability, newPassToVideo);
        assertEquals(updatedAbility.getPassToVideo(), newPassToVideo);
    }

}