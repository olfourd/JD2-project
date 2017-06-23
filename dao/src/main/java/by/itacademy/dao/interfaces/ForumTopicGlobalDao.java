package by.itacademy.dao.interfaces;

import by.itacademy.entity.common.ForumTopicGlobal;
import by.itacademy.entity.common.ForumTopicSimple;

import java.util.List;

public interface ForumTopicGlobalDao extends BaseDao<ForumTopicGlobal> {
    ForumTopicGlobal getByName(String name);

    ForumTopicGlobal changeName(ForumTopicGlobal topic, String name);

    List<ForumTopicSimple> getAllSimpleTopicsById(Long id);
}
