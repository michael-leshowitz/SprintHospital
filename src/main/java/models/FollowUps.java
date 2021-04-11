package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "followups")
public class FollowUps implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer followUp_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id")
    private Staff staff;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "date_id")
    private Dates dates;

    public FollowUps() {
    }

//    public FollowUps(Builder builder) {
//        this.followUp_id = builder.followUp_id;
//        this.staff_id = builder.staff_id;
//        this.patient_id = builder.patient_id;
//        this.date_id = builder.date_id;
//    }
//
//    public  static class Builder{
//        private Integer followUp_id;
//        private Integer staff_id;
//        private Integer patient_id;
//        private Integer date_id;
//
//        public Builder withFollowUpID(Integer followUp_id){
//            this.followUp_id = followUp_id;
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
//        public Builder withDateID(Integer date_id){
//            this.date_id = date_id;
//            return this;
//        }
//
//        public FollowUps build(){return new FollowUps(this);}
//    }
//
//    public Integer getFollowUp_id() {
//        return followUp_id;
//    }
//
//    public void setFollowUp_id(Integer followUp_id) {
//        this.followUp_id = followUp_id;
//    }
//
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
//    public Integer getDate_id() {
//        return date_id;
//    }
//
//    public void setDate_id(Integer date_id) {
//        this.date_id = date_id;
//    }


    public Integer getFollowUp_id() {
        return followUp_id;
    }

    public void setFollowUp_id(Integer followUp_id) {
        this.followUp_id = followUp_id;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    @Override
    public String toString() {
        return "followups{" +
                "followUp_id='" + followUp_id + '\'' +
                ", staff_id='" + staff.getStaff_id() + '\'' +
                ", patient_id='" + patient.getPatient_id() + '\'' +
                ", date_id='" + dates.getDate_id() + '\'' +
                '}';
    }
}
