package pojo;

public class User {
    private int id;
    private String userName;
    private String sex;
    private String email;
    private String nickName;
    private String password;

    public User() {
    }

    public User(int id, String userName, String sex, String email, String nickName, String password) {
        this.id = id;
        this.userName = userName;
        this.sex = sex;
        this.email = email;
        this.nickName = nickName;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public String toString() {
        return "id = " + id +
                " name = " + userName +
                " sex = " + sex;
    }
}
