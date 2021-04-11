package models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name="past_appointments")
public class Past_Appointments implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer app_id;
//    private Integer date_id;
    private LocalTime start_time;
    private LocalTime end_time;
//    private Integer staff_id;
//    private Integer patient_id;
//    private Integer dept_id;
    private Integer room_id;
//    private Integer service_id;
//    private Integer note_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="patient_id", nullable = false)
    private Patient patient;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="staff_id", nullable = false)
    private Staff staff;
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
    private Notes notes;

    public Past_Appointments() {
    }

//    public Past_Appointments(Builder builder) {
//        this.app_id = builder.app_id;
//        this.date_id = builder.date_id;
//        this.start_time = builder.start_time;
//        this.end_time = builder.end_time;
//        this.staff_id = builder.staff_id;
//        this.patient_id = builder.patient_id;
//        this.dept_id = builder.dept_id;
//        this.room_id = builder.room_id;
//        this.service_id = builder.service_id;
//        this.note_id = builder.note_id;
//    }
//
//    public static class Builder{
//        private Integer app_id;
//        private Integer date_id;
//        private LocalTime start_time;
//        private LocalTime end_time;
//        private Integer staff_id;
//        private Integer patient_id;
//        private Integer dept_id;
//        private Integer room_id;
//        private Integer service_id;
//        private Integer note_id;
//
//        public Builder withAppID(Integer app_id){
//            this.app_id = app_id;
//            return this;
//        }
//
//        public Builder withDateID(Integer date_id){
//            this.date_id = date_id;
//            return this;
//        }
//
//        public Builder withStartTime(LocalTime start_time){
//            this.start_time = start_time;
//            return this;
//        }
//
//        public Builder withEndTime(LocalTime end_time){
//            this.end_time = end_time;
//            return this;
//        }
//
//        public Builder withStaffID(Integer staff_id){
//            this.staff_id = staff_id;
//            return this;
//        }
//
//        public Builder withPatientID(Integer patient_id){
//            this.patient_id = patient_id;
//            return this;
//        }
//
//        public Builder withDeptID(Integer dept_id){
//            this.dept_id = dept_id;
//            return this;
//        }
//
//        public Builder withRoomID(Integer room_id){
//            this.room_id = room_id;
//            return this;
//        }
//
//        public Builder withServiceID(Integer service_id){
//            this.service_id = service_id;
//            return this;
//        }
//
//        public Builder withNoteID(Integer note_id){
//            this.note_id = note_id;
//            return this;
//        }
//
//        public Past_Appointments build(){return new Past_Appointments(this);}
//    }
    public Integer getApp_id() {
        return app_id;
    }

    public void setApp_id(Integer app_id) {
        this.app_id = app_id;
    }

//    public Integer getDate_id() {
//        return date_id;
//    }
//
//    public void setDate_id(Integer date_id) {
//        this.date_id = date_id;
//    }

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

//    public Integer getStaff_id() {
//        return staff_id;
//    }
//
//    public void setStaff_id(Integer staff_id) {
//        this.staff_id = staff_id;
//    }
//
//    public Integer getPatient_id() {
//        return patient_id;
//    }
//
//    public void setPatient_id(Integer patient_id) {
//        this.patient_id = patient_id;
//    }
//
//    public Integer getDept_id() {
//        return dept_id;
//    }
//
//    public void setDept_id(Integer dept_id) {
//        this.dept_id = dept_id;
//    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

//    public Integer getService_id() {
//        return service_id;
//    }
//
//    public void setService_id(Integer service_id) {
//        this.service_id = service_id;
//    }
//
//    public Integer getNote_id() {
//        return note_id;
//    }
//
//    public void setNote_id(Integer note_id) {
//        this.note_id = note_id;
//    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
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
                ", staff_id='" + staff.getStaff_id() + '\'' +
                ", patient_id='" + patient.getPatient_id() + '\'' +
                ", dept_id='" + departments.getDept_id() + '\'' +
                ", room_id='" + room_id + '\'' +
                ", service_id='" + services.getService_id() + '\'' +
                ", note_id='" + notes.getNote_id() + '\'' +
                "}";
    }
}
