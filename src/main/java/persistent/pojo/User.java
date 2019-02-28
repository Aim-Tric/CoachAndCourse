package persistent.pojo;

import java.util.Arrays;
import java.util.List;

public class User {
    private Integer id;
    private String username, sex, email, nickname, password;
    private Byte[] avatar;
    private String role;
    private List<Course> Courses;

    public User() {
    }

    public User(Integer id, String username, String sex, String email, String nickname, String password, Byte[] avatar, String role) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.avatar = avatar;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(Byte[] avatar) {
        this.avatar = avatar;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Course> getCourses() {
        return Courses;
    }

    public void setCourses(List<Course> courses) {
        Courses = courses;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", avatar=" + Arrays.toString(avatar) +
                ", role='" + role + '\'' +
                ", Courses=" + Courses +
                '}';
    }
}
