package by.itacademy.entity;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by цифра on 22.05.2017.
 */
public class News {

    private  long id;
    private String name;
    private String passToPicture;
    private Comment mostPopularComment;
    private List<Comment> comments;
    private LocalDate date;

    public News() {
    }

    public News(long id, String name, String passToPicture, Comment mostPopularComment, List<Comment> comments, LocalDate date) {
        this.id = id;
        this.name = name;
        this.passToPicture = passToPicture;
        this.mostPopularComment = mostPopularComment;
        this.comments = comments;
        this.date = date;
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

    public Comment getMostPopularComment() {
        return mostPopularComment;
    }

    public void setMostPopularComment(Comment mostPopularComment) {
        this.mostPopularComment = mostPopularComment;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
