package by.itacademy.dao.classes;

import by.itacademy.entity.common.RoleOfUser;
import by.itacademy.entity.common.Topic;
import by.itacademy.entity.common.User;
import by.itacademy.entity.other.UserRole;
import by.itacademy.util.DataImporterToH2;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.*;


public class UserDaoTest {

    private static UserDaoImpl userDao = new UserDaoImpl();

    @BeforeClass
    public static void init() {
        DataImporterToH2.getInstance().importTestData(userDao.getSessionFactory());
    }

    @Test
    public void saveGetById() throws Exception {
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
        User user = userDao.getById(3L);
        String src = "D:/pictures";
        User changedUser = userDao.changePicture(user, src);
        assertEquals(changedUser.getSrcAvatar(), src);

    }

    @Test
    public void changeNickName() throws Exception {
        User user = userDao.getById(3L);
        String nickName = "Vayne";
        User changedUser = userDao.changeNickName(user, nickName);
        assertEquals(changedUser.getNickName(), nickName);
    }

    @Test
    public void changePassword() throws Exception {
        User user = userDao.getById(3L);
        String password = "112233";
        User changedUser = userDao.changePassword(user, password);
        assertEquals(changedUser.getPassword(), password);
    }

    @Test
    public void changeName() throws Exception {
        User user = userDao.getById(3L);
        String name = "Alex";
        User changedUser = userDao.changeName(user, name);
        assertEquals(changedUser.getName(), name);
    }

    @Test
    public void changeCountry() throws Exception {
        User user = userDao.getById(3L);
        String country = "Belarus";
        User changedUser = userDao.changeCountry(user, country);
        assertEquals(changedUser.getAddress().getCountry(), country);
    }

    @Test
    public void changeCity() throws Exception {
        User user = userDao.getById(3L);
        String city = "Minsk";
        User changedUser = userDao.changeCity(user, city);
        assertEquals(changedUser.getAddress().getCity(), city);
    }

    @Test
    public void getCreatedTopicsById() throws Exception {
        List<Topic> topics = userDao.getCreatedTopicsById(1L);
        List<String> namesOfTopics = topics.stream().map(Topic::getName).collect(toList());
        assertThat(namesOfTopics, contains("1st topic Alistar", "2nd topic Alistar"));
    }

    @Test
    public void getAllRolles() throws Exception {
        List<RoleOfUser> rolles = userDao.getAllRolles(2L);
        List<UserRole> collect = rolles.stream().map(RoleOfUser::getRole).collect(toList());
        assertTrue(collect.contains(UserRole.ADMIN));
        assertTrue(collect.contains(UserRole.USER));
    }

    @Test
    public void getAllTopicsWhereUserTakePartInById() throws Exception {
        List<Topic> topics = userDao.getAllTopicsWhereUserTakePartInById(1L);
        List<String> nameOfTopics = topics.stream().map(Topic::getName).collect(toList());
        assertThat(nameOfTopics, contains("1st topic Alistar"));
    }

}