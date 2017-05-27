package by.itacademy.entity;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by цифра on 22.05.2017.
 */
public class Topic extends Messange {

    private String name;
    private List<Comment> commets;

    public Topic() {

    }

    public Topic(long id, User user, String text, LocalDate date, String name, List<Comment> commets) {
        super(id, user, text, date);
        this.name = name;
        this.commets = commets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Comment> getCommets() {
        return commets;
    }

    public void setCommets(List<Comment> commets) {
        this.commets = commets;
    }
}
