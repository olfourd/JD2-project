package by.itacademy.dao.classes;

import by.itacademy.dao.interfaces.AbilityDao;
import by.itacademy.entity.common.HeroAbility;
import by.itacademy.util.DataImporterToH2;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class AbilityDaoTest extends BaseDaoTest {

    @Autowired
    private AbilityDao abilityDao;
    @Autowired
    private DataImporterToH2 importerToH2;

    @Before
    public void init() {
        importerToH2.importTestData(abilityDao.getSessionFactory().getCurrentSession());
    }

    @Test
    public void getByName() {
        String nameAbility = "Headbutt";
        HeroAbility ability = abilityDao.getByName(nameAbility);
        assertEquals(ability.getName(), nameAbility);
    }

    @Test
    public void changeName() {
        HeroAbility ability = abilityDao.getByName("HeadButt");
        String newName = "QWERTY";
        HeroAbility updatedAbility = abilityDao.changeName(ability, newName);
        assertEquals(updatedAbility.getName(), newName);
    }

    @Test
    public void changePicture() {
        HeroAbility ability = abilityDao.getByName("HeadButt");
        String newPassToPicture = "QWERTY";
        HeroAbility updatedAbility = abilityDao.changePicture(ability, newPassToPicture);
        assertEquals(updatedAbility.getPassToImg(), newPassToPicture);
    }

    @Test
    public void changeVideo() {
        HeroAbility ability = abilityDao.getByName("HeadButt");
        String newPassToVideo = "QWERTY";
        HeroAbility updatedAbility = abilityDao.changeVideo(ability, newPassToVideo);
        assertEquals(updatedAbility.getPassToVideo(), newPassToVideo);
    }

}