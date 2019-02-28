package persistent.pojo;

import java.util.Date;

public class Comment {
    private User user;
    private Integer id;
    private String comment;
    private Date time;

    public Comment() {}

    public Comment(User user, Integer id, String comment, Date time) {
        this.user = user;
        this.id = id;
        this.comment = comment;
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "user=" + user +
                ", id=" + id +
                ", comment='" + comment + '\'' +
                ", time=" + time +
                '}';
    }
}
