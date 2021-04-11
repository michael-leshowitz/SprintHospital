package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "app_schedule")
public class App_Schedule implements Serializable {
    @Id
    @ManyToOne
    @MapsId
    @JoinColumn(name = "app_id")
    private Appointments appointments;
    @Id
    @ManyToOne
    @MapsId
    @JoinColumn(name = "staff_id")
    private Staff staff;

    public App_Schedule() {
    }

    //    public App_Schedule(Builder builder) {
//        this.app_id = builder.app_id;
//        this.staff_id = builder.staff_id;
//    }
//
//
//    public static class Builder{
//        private Integer app_id;
//        private Integer staff_id;
//
//        public Builder withAppID(Integer app_id){
//            this.app_id = app_id;
//            return this;
//        }
//
//        public Builder withStaffID(Integer staff_id){
//            this.staff_id = staff_id;
//            return this;
//        }
//        public App_Schedule build(){
//            return new App_Schedule(this);
//        }
//    }

//    public Integer getApp_id() {
//        return app_id;
//    }
//
//    public void setApp_id(Integer app_id) {
//        this.app_id = app_id;
//    }
//
//    public Integer getStaff_id() {
//        return staff_id;
//    }
//
//    public void setStaff_id(Integer staff_id) {
//        this.staff_id = staff_id;
//    }

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
