package by.itacademy.entity;

import java.time.LocalDate;

/**
 * Created by цифра on 22.05.2017.
 */
public class Comment extends Messange {
    private long likes;

    public Comment() {
    }

    public Comment(long id, User user, String text, LocalDate date, long likes) {
        super(id, user, text, date);
        this.likes = likes;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }
}
