package by.itacademy.entity;

import java.util.List;

/**
 * Created by цифра on 22.05.2017.
 */
public class GlobalTopic {

    private long id;
    private List<Topic> topics;

    public GlobalTopic() {
    }

    public GlobalTopic(long id, List<Topic> topics) {
        this.id = id;
        this.topics = topics;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}
