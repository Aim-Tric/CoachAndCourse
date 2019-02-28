package persistent.pojo;

import java.util.Date;
import java.util.List;

/**
 * 课程类，包含了课程的所有内容
 */
public class Course {

    private Integer id, teaid;
    private String name, overview, source, type, poster, index, status;
    private Double score;
    private Integer max_person;
    private Date start_time, end_time, signup_time;

    private List<Comment> comments;
    private List<User> users;

    public Course(){}

    public Course(Integer id, Integer teaid, String name, String overview, String source, String type, String poster, String index, String status, Double score, Integer max_person, Date start_time, Date end_time, Date signup_time) {
        this.id = id;
        this.teaid = teaid;
        this.name = name;
        this.overview = overview;
        this.source = source;
        this.type = type;
        this.poster = poster;
        this.index = index;
        this.status = status;
        this.score = score;
        this.max_person = max_person;
        this.start_time = start_time;
        this.end_time = end_time;
        this.signup_time = signup_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeaid() {
        return teaid;
    }

    public void setTeaid(Integer teaid) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getMax_person() {
        return max_person;
    }

    public void setMax_person(Integer max_person) {
        this.max_person = max_person;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Date getSignup_time() {
        return signup_time;
    }

    public void setSignup_time(Date signup_time) {
        this.signup_time = signup_time;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", teaid=" + teaid +
                ", name='" + name + '\'' +
                ", overview='" + overview + '\'' +
                ", source='" + source + '\'' +
                ", type='" + type + '\'' +
                ", poster='" + poster + '\'' +
                ", index='" + index + '\'' +
                ", status='" + status + '\'' +
                ", score=" + score +
                ", max_person=" + max_person +
                '}';
    }
}
