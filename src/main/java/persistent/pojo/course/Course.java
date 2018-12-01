package persistent.pojo.course;

import java.sql.Date;

/**
 * 课程类，包含了课程的所有内容
 */
public class Course {

    private long id;
    private String name, overview, source, type, poster, index, status;
    private int score, max_person;
    private Date signup_time, start_time, end_time;

    public Course(){}

    public Course(String name, String overview, String type) {
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

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public int getMax_person() { return max_person; }

    public void setMax_person(int max_person) { this.max_person = max_person; }

    public int getScore() { return score; }

    public void setScore(int score) { this.score = score; }

    public Date getSignup_time() {
        return signup_time;
    }

    public void setSignup_time(Date signup_time) {
        this.signup_time = signup_time;
    }

    public Date getStart_time() { return start_time; }

    public void setStart_time(Date start_time) { this.start_time = start_time; }

    public Date getEnd_time() { return end_time; }

    public void setEnd_time(Date end_time) { this.end_time = end_time; }

    public String toString() {
        return "id = " + this.id + " name = " + this.name + ", type = " + type;
    }

}
