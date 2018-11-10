package persistent.pojo.user;

public class User {
    private int id;
    private String username;
    private String sex;
    private String email;
    private String nickname;
    private String password;

    public User() {
    }

    public User(String username, String sex, String email, String nickName, String password) {
        this.username = username;
        this.sex = sex;
        this.email = email;
        this.nickname = nickName;
        this.password = password;
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

    public int getId() {
        return id;
    }
    public void setId(int id) {
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


    public String toString() {
        return "id = " + id +
                " username = " + username +
                " sex = " + sex;
    }
}
