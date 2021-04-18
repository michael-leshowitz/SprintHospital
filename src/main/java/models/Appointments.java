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
    @Column(name="end_time_expected")
    private LocalTime end_time_expected;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="patient_id", referencedColumnName = "user_id")
    private Users patient;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="staff_id", referencedColumnName = "user_id")
    private Users staff;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="creator_id", referencedColumnName = "user_id")
    private Users creator;
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

    public LocalTime getEnd_time_expected() {
        return end_time_expected;
    }

    public void setEnd_time_expected(LocalTime end_time_expected) {
        this.end_time_expected = end_time_expected;
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

    public Users getPatient() {
        return patient;
    }

    public void setPatient(Users patient) {
        this.patient = patient;
    }

    public Users getStaff() {
        return staff;
    }

    public void setStaff(Users staff) {
        this.staff = staff;
    }

    public Users getCreator() {
        return creator;
    }

    public void setCreator(Users creator) {
        this.creator = creator;
    }

    @Override
    public String toString(){
        return "Appointments{" +
                "app_id='" + app_id + '\'' +
                ", date_id='" + dates.getDate_id() + '\'' +
                ", time='" + time + '\'' +

                ", service_id='" + service_id + '\'' +
                ", date_created='" + date_created + '\'' +
                ", creator_id='" + creator + '\'' +
                ", dept_id='" + departments.getDept_id() + '\'' +
                ", end_time_expected='" + end_time_expected + '\'' +
                "}";

    }
}
