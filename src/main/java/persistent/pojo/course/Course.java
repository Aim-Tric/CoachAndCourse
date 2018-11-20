package persistent.pojo.course;

import persistent.pojo.user.User;

import java.util.Date;
import java.util.List;

public class Course {

    private long id, teaid;
    private List<User> students;
    private String name, overview, source, type, poster, index, status;
    private int score, max_person;
    private Date start_time, end_time;

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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public int getMax_person() { return max_person; }

    public void setMax_person(int max_person) { this.max_person = max_person; }

    public int getScore() { return score; }

    public void setScore(int score) { this.score = score; }

    public Date getStart_time() { return start_time; }

    public void setStart_time(Date start_time) { this.start_time = start_time; }

    public Date getEnd_time() { return end_time; }

    public void setEnd_time(Date end_time) { this.end_time = end_time; }

    public String toString() {
        return "name = " + this.name + ", type = " + type;
    }

}
