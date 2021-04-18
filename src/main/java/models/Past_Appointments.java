package models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name="past_appointments")
public class Past_Appointments implements Serializable {
    @Id
    @Column(name="app_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer app_id;
//    private Integer date_id;

    @Column(name="start_time")
    private LocalTime start_time;
    @Column(name="end_time")
    private LocalTime end_time;
    @Column(name="room_id")
    private Integer room_id;


    @ManyToMany(fetch = FetchType.LAZY)
    private List<Users> users;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="date_id", nullable = false)
    private Dates dates;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dept_id", nullable = false)
    private Departments departments;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="service_id", nullable = false)
    private Services services;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="note_id")
    private Notes notes;

    public Past_Appointments() {
    }

    public Integer getApp_id() {
        return app_id;
    }

    public void setApp_id(Integer app_id) {
        this.app_id = app_id;
    }


    public LocalTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }

    public LocalTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }



    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "past_appointments{" +
                "app_id='" + app_id + '\'' +
                ", date_id='" + dates.getDate_id() + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +

                ", dept_id='" + departments.getDept_id() + '\'' +
                ", room_id='" + room_id + '\'' +
                ", service_id='" + services.getService_id() + '\'' +
                ", note_id='" + notes.getNote_id() + '\'' +
                "}";
    }
}
