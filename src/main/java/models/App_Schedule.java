package models;

import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "app_schedule")
@IdClass(App_ScheduleId.class)
public class App_Schedule implements Serializable {
   @Id
   @Column(name ="app_id")
   private Integer app_id;

   @Id
   @Column(name = "staff_id")
   private Integer staff_id;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "app_id")
    private Appointments appointments;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "staff_id")
    private Staff staff;

    public App_Schedule() {
    }


    public Appointments getAppointments() {
        return appointments;
    }

    public void setAppointments(Appointments appointments) {
        this.appointments = appointments;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString(){
        return "app_schedule{" +
                "app_id='" + appointments.getApp_id() + '\'' +
                ", staff_id='" + staff.getStaff_id() + '\'' +
                '}';
    }
}
