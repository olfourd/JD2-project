package by.itacademy.entity;

import java.time.LocalDate;

/**
 * Created by цифра on 22.05.2017.
 */
public class Messange {

    private long id;
    private User user;
    private String text;
    private LocalDate date;

    public Messange() {
    }

    public Messange(long id, User user, String text, LocalDate date) {
        this.id = id;
        this.user = user;
        this.text = text;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
