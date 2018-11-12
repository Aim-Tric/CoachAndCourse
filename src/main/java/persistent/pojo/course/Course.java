package persistent.pojo.course;

import persistent.pojo.user.User;

import java.util.List;

public class Course {

    private int id, teaid;
    private List<User> students;
    private String name;
    private String info;
    private String sourse;
    private String type;
    private String imageview;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeaid() {
        return teaid;
    }

    public void setTeaid(int teaid) {
        this.teaid = teaid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getSourse() {
        return sourse;
    }

    public void setSourse(String sourse) {
        this.sourse = sourse;
    }

    public String getImageview() { return imageview; }

    public void setImageview(String imageview) { this.imageview = imageview; }

    public List<User> getStudents() { return students; }

    public void setStudents(List<User> students) { this.students = students; }

}
