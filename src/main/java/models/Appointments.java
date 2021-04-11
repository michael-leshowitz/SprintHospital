package models;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "appointments")
public class Appointments implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer app_id;
    @Temporal(TemporalType.TIME)
    private Date time;
    private Integer service_id;
    private Date date_created;
    private Integer creator_id;
    private LocalTime end_time_expected;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="patient_id", nullable = false)
    private Patient patient;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="staff_id", nullable = false)
    private Staff staff;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dept_id", nullable = false)
    private Departments departments;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="date_id", nullable = false)
    private Dates dates;

    public Appointments() {
    }

//    public Appointments(Builder builder){
//        this.app_id = builder.app_id;
//        this.date_id = builder.date_id;
//        this.time = builder.time;
////        this.staff_id = builder.staff_id;
//        //this.patient_id = builder.patient_id;
//        //this.service_id = builder.service_id;
//        this.date_created = builder.date_created;
//        this.creator_id = builder.creator_id;
//        this.dept_id = builder.dept_id;
//        this.end_time_expected = builder.end_time_expected;
//    }
//
//    public static class Builder{
//        private Integer app_id;
//        private Integer date_id;
//        private LocalTime time;
////        private Integer staff_id;
////        private Integer patient_id;
////        private Integer service_id;
//        private Date date_created;
//        private Integer creator_id;
//        private Integer dept_id;
//        private LocalTime end_time_expected;
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
//        public Builder withTime(LocalTime time){
//            this.time = time;
//            return this;
//        }

//        public Builder withStaffID(Integer staff_id){
//            this.staff_id = staff_id;
//            return this;
//        }

//        public Builder withPatientID(Integer patient_id){
//            this.patient_id = patient_id;
//            return this;
//        }

//        public Builder withServiceID(Integer service_id){
//            this.service_id = service_id;
//            return this;
//        }

//        public Builder withDate(Date date_created){
//            this.date_created = date_created;
//            return this;
//        }
//
//        public Builder withCreatorID(Integer creator_id){
//            this.creator_id = creator_id;
//            return this;
//        }
//
//        public Builder withDeptID(Integer dept_id){
//            this.dept_id = dept_id;
//            return this;
//        }
//
//        public Builder withEndTimeExpected(LocalTime end_time_expected){
//            this.end_time_expected = end_time_expected;
//            return this;
//        }
//        public Appointments build(){return new Appointments(this);}
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

//    public Integer getStaff_id() {
//        return staff_id;
//    }

//    public void setStaff_id(Integer staff_id) {
//        this.staff_id = staff_id;
//    }

//    public Integer getPatient_id() {
//        return patient_id;
//    }

//    public void setPatient_id(Integer patient_id) {
//        this.patient_id = patient_id;
//    }

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

//    public Integer getDept_id() {
//        return dept_id;
//    }
//
//    public void setDept_id(Integer dept_id) {
//        this.dept_id = dept_id;
//    }

    public LocalTime getEnd_time_expected() {
        return end_time_expected;
    }

    public void setEnd_time_expected(LocalTime end_time_expected) {
        this.end_time_expected = end_time_expected;
    }

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
                ", staff_id='" + staff.getStaff_id() + '\'' +
                ", patient_id='" + patient.getPatient_id() + '\'' +
                ", service_id='" + service_id + '\'' +
                ", date_created='" + date_created + '\'' +
                ", creator_id='" + creator_id + '\'' +
                ", dept_id='" + departments.getDept_id() + '\'' +
                ", end_time_expected='" + end_time_expected + '\'' +
                "}";

    }
}
