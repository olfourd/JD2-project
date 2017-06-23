package by.itacademy.dao.interfaces;

import by.itacademy.entity.common.ForumPost;
import by.itacademy.entity.common.ForumTopicGlobal;
import by.itacademy.entity.common.ForumTopicSimple;

import java.util.List;

public interface ForumTopicSimpleDao extends BaseDao<ForumTopicSimple> {

    ForumTopicSimple getByName(String name);

    ForumTopicSimple changeTheme(ForumTopicSimple topicSimple, ForumTopicGlobal topicGlobal);

    List<ForumPost> getAllForumPosts(Long primaryKey);

    ForumTopicSimple changeText(ForumTopicSimple topicSimple, String text);
}
