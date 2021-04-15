package models;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "appointments")
public class Appointments implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="app_id")
    private Integer app_id;
    @Temporal(TemporalType.TIME)
    @Column(name="time")
    private Date time;
    @Column(name="service_id")
    private Integer service_id;
    @Column(name="date_created")
    private Date date_created;
    @Column(name="creator_id")
    private Integer creator_id;
    @Column(name="end_time_expected")
    private LocalTime end_time_expected;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Users> user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dept_id", nullable = false)
    private Departments departments;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="date_id", nullable = false)
    private Dates dates;

    public Appointments() {
    }


    public Integer getApp_id() {
        return app_id;
    }

    public void setApp_id(Integer app_id) {
        this.app_id = app_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Integer getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(Integer creator_id) {
        this.creator_id = creator_id;
    }

    public LocalTime getEnd_time_expected() {
        return end_time_expected;
    }

    public void setEnd_time_expected(LocalTime end_time_expected) {
        this.end_time_expected = end_time_expected;
    }

    public List<Users> getUser() {
        return user;
    }

    public void setUser(List<Users> user) {
        this.user = user;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }


    @Override
    public String toString(){
        return "Appointments{" +
                "app_id='" + app_id + '\'' +
                ", date_id='" + dates.getDate_id() + '\'' +
                ", time='" + time + '\'' +

                ", service_id='" + service_id + '\'' +
                ", date_created='" + date_created + '\'' +
                ", creator_id='" + creator_id + '\'' +
                ", dept_id='" + departments.getDept_id() + '\'' +
                ", end_time_expected='" + end_time_expected + '\'' +
                "}";

    }
}
