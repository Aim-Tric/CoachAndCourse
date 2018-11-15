package persistent.pojo.course;

import persistent.pojo.user.User;

import java.util.List;

public class Course {

    private long id, teaid;
    private List<User> students;
    private String name, overview, sourse, type, imageview, index;

    public Course(){}
    public Course(long teaid, String name, String overview, String type) {
        this.teaid = teaid;
        this.name = name;
        this.overview = overview;
        this.type = type;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTeaid() {
        return teaid;
    }

    public void setTeaid(long teaid) {
        this.teaid = teaid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getSourse() {
        return sourse;
    }

    public void setSourse(String sourse) {
        this.sourse = sourse;
    }

    public String getImageview() {
        return imageview;
    }

    public void setImageview(String imageview) {
        this.imageview = imageview;
    }

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }

    public String toString() {
        return "name = " + this.name;
    }

}
