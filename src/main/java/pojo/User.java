package pojo;

public class User {
    private int id;
    private String name;
    private String sex;
    private String password;

    public User(){}

    public User(int id, String name, String sex, String password){
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return "id = " + id +
                " name = " + name +
                " sex = " + sex +
                " password = " + password;
    }
}
