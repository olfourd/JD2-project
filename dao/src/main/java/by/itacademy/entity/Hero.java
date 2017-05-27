package by.itacademy.entity;

import java.util.List;

/**
 * Created by цифра on 22.05.2017.
 */
public class Hero {

    private long id;
    private String name;
    private String passToPicture;
    private List<Topic> topics;

    public Hero() {
    }

    public Hero(long id, String name, String passToPicture, List<Topic> topics) {
        this.id = id;
        this.name = name;
        this.passToPicture = passToPicture;
        this.topics = topics;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassToPicture() {
        return passToPicture;
    }

    public void setPassToPicture(String passToPicture) {
        this.passToPicture = passToPicture;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}
