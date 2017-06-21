package by.itacademy.dao.classes;

import by.itacademy.dao.interfaces.UserDao;
import by.itacademy.entity.common.Message;
import by.itacademy.entity.common.RoleOfUser;
import by.itacademy.entity.common.Topic;
import by.itacademy.entity.common.User;
import by.itacademy.entity.other.UserRole;
import by.itacademy.util.DataImporterToH2;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
@Transactional
public class UserDaoTest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private DataImporterToH2 dataImport;

    @Before
    public void init() {
        dataImport.importTestData(userDao.getSessionFactory().getCurrentSession());
    }

    @Test
    public void getByLogin() {
        String login = "Qwerty";
        User user = userDao.getByLogin(login);
        assertEquals(user.getLogin(), login);
    }

    @Test
    public void saveGetById() {
        String name = "Hamlo";
        User user = new User(name, name, name);
        User savedUser = userDao.save(user);
        assertEquals(savedUser.getLogin(), name);
        assertEquals(savedUser.getPassword(), name);
        assertEquals(savedUser.getNickName(), name);

        long id = savedUser.getId();
        User getUserById = userDao.getById(id);
        assertEquals(savedUser.getLogin(), getUserById.getLogin());
        assertEquals(savedUser.getPassword(), getUserById.getPassword());
        assertEquals(savedUser.getNickName(), getUserById.getNickName());
    }

    @Test
    public void updateDelete() throws Exception {
        String name = "Archer";
        User user = new User(name, name, name);
        userDao.save(user);
        user.setNickName("David");
        User updatedUser = userDao.update(user);
        assertEquals(updatedUser.getNickName(), "David");

        boolean resultDelete = userDao.delete(updatedUser);
        assertTrue(resultDelete);
    }

    @Test
    public void getAll() throws Exception {
        List<User> result = userDao.getAll();
        List<String> loginsOfUsers = result.stream().map(User::getLogin).collect(toList());
        assertThat(loginsOfUsers, contains("Qwerty", "Olfourd", "DeGriz"));
    }

    @Test
    public void changePicture() throws Exception {
        User user = userDao.getByLogin("DeGriz");
        String src = "D:/pictures";
        User changedUser = userDao.changePicture(user, src);
        assertEquals(changedUser.getSrcAvatar(), src);

    }

    @Test
    public void changeNickName() throws Exception {
        User user = userDao.getByLogin("DeGriz");
        String nickName = "Vayne";
        User changedUser = userDao.changeNickName(user, nickName);
        assertEquals(changedUser.getNickName(), nickName);
    }

    @Test
    public void changePassword() throws Exception {
        User user = userDao.getByLogin("DeGriz");
        String password = "112233";
        User changedUser = userDao.changePassword(user, password);
        assertEquals(changedUser.getPassword(), password);
    }

    @Test
    public void changeName() throws Exception {
        User user = userDao.getByLogin("DeGriz");
        String name = "Alex";
        User changedUser = userDao.changeName(user, name);
        assertEquals(changedUser.getName(), name);
    }

    @Test
    public void changeCountry() throws Exception {
        User user = userDao.getByLogin("DeGriz");
        String country = "Belarus";
        User changedUser = userDao.changeCountry(user, country);
        assertEquals(changedUser.getAddress().getCountry(), country);
    }

    @Test
    public void changeCity() throws Exception {
        User user = userDao.getByLogin("DeGriz");
        String city = "Minsk";
        User changedUser = userDao.changeCity(user, city);
        assertEquals(changedUser.getAddress().getCity(), city);
    }

    @Test
    public void getCreatedTopicsById() throws Exception {
        User user = userDao.getByLogin("Qwerty");
        List<Topic> topics = userDao.getCreatedTopicsById(user.getId());
        List<String> namesOfTopics = topics.stream().map(Topic::getName).collect(toList());
        assertThat(namesOfTopics, contains("1st topic Alistar", "2nd topic Alistar"));
    }

    @Test
    public void getAllRolles() throws Exception {
        User user = userDao.getByLogin("Olfourd");
        List<RoleOfUser> rolles = userDao.getAllRolles(user.getId());
        List<UserRole> collect = rolles.stream().map(RoleOfUser::getRole).collect(toList());
        assertTrue(collect.contains(UserRole.ADMIN));
        assertTrue(collect.contains(UserRole.USER));
    }
}