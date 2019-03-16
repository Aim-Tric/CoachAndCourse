package persistent.pojo;

import java.util.List;

/**
 * 订单POJO
 */
public class Order {
    private Integer id;
    private Long total;
    private List<Course> courses;
    private User user;

    public Order() {
    }

    public Order(Integer id, Long total, List<Course> courses, User user) {
        this.id = id;
        this.total = total;
        this.courses = courses;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "total=" + total +
                '}';
    }
}
