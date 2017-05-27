package by.itacademy.entity;

/**
 * Created by цифра on 22.05.2017.
 */
public class Role {
    private long id;
    private String type;

    public Role() {
    }

    public Role(long id, String type) {
        this.id = id;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
