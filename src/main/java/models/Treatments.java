package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "treatments")
public class Treatments implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer treatment_id;
    private Integer supply;
    private Integer dosage;
    private Date prescribe_date;
    private Integer refills;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="patient_id", nullable = false)
    private Patient patient;
    @OneToOne(fetch = FetchType.LAZY)
    private Medications medication;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FollowUps> followUps = new ArrayList<>();

    public Treatments() {
    }

//    public Treatments(Builder builder) {
//        this.treatment_id = builder.treatment_id;
//        this.medication_id = builder.medication_id;
//        this.supply = builder.supply;
//        this.dosage = builder.dosage;
//        this.prescribe_date = builder.prescribe_date;
//        this.refills = builder.refills;
//        this.followUp_id = builder.followUp_id;
//    }
//
//    public static class Builder{
//        private Integer treatment_id;
//        private Integer patient_id;
//        private Integer medication_id;
//        private Integer supply;
//        private Integer dosage;
//        private Date prescribe_date;
//        private Integer refills;
//        private Integer followUp_id;
//
//        public Builder withTreatmentID(Integer treatment_id){
//            this.treatment_id = treatment_id;
//            return this;
//        }
//
//        public Builder withPatientID(Integer patient_id){
//            this.patient_id = patient_id;
//            return this;
//        }
//
//        public Builder withMedicationID(Integer medication_id){
//            this.medication_id = medication_id;
//            return this;
//        }
//
//        public Builder withSupply(Integer supply){
//            this.supply = supply;
//            return this;
//        }
//
//        public Builder withDosage(Integer dosage){
//            this.dosage = dosage;
//            return this;
//        }
//
//        public Builder withPrescribeDate(Date prescribe_date){
//            this.prescribe_date = prescribe_date;
//            return this;
//        }
//
//        public Builder withRefills(Integer refills){
//            this.refills = refills;
//            return this;
//        }
//
//        public Builder withFollowUpID(Integer followUp_id){
//            this.followUp_id = followUp_id;
//            return this;
//        }
//
//        public Treatments build(){return new Treatments(this);}
//    }
    public Integer getTreatment_id() {
        return treatment_id;
    }

    public void setTreatment_id(Integer treatment_id) {
        this.treatment_id = treatment_id;
    }

//    public Integer getPatient_id() {
//        return patient_id;
//    }
//
//    public void setPatient_id(Integer patient_id) {
//        this.patient_id = patient_id;
//    }
//
//    public Integer getMedication_id() {
//        return medication_id;
//    }
//
//    public void setMedication_id(Integer medication_id) {
//        this.medication_id = medication_id;
//    }

    public Integer getSupply() {
        return supply;
    }

    public void setSupply(Integer supply) {
        this.supply = supply;
    }

    public Integer getDosage() {
        return dosage;
    }

    public void setDosage(Integer dosage) {
        this.dosage = dosage;
    }

    public Date getPrescribe_date() {
        return prescribe_date;
    }

    public void setPrescribe_date(Date prescribe_date) {
        this.prescribe_date = prescribe_date;
    }

    public Integer getRefills() {
        return refills;
    }

    public void setRefills(Integer refills) {
        this.refills = refills;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medications getMedication() {
        return medication;
    }

    public void setMedication(Medications medication) {
        this.medication = medication;
    }

    public List<FollowUps> getFollowUps() {
        return followUps;
    }

    public void setFollowUps(List<FollowUps> followUps) {
        this.followUps = followUps;
    }

    //    public Integer getFollowUp_id() {
//        return followUp_id;
//    }
//
//    public void setFollowUp_id(Integer followUp_id) {
//        this.followUp_id = followUp_id;
//    }

    @Override
    public String toString() {
        return "treatments{" +
                "treatment_id='" + treatment_id + '\'' +
                ", patient_id='" + patient.getPatient_id() + '\'' +
                ", medication_id='" + medication.getMedication_id() + '\'' +
                ", supply='" + supply + '\'' +
                ", dosage='" + dosage + '\'' +
                ", prescribe_date='" + prescribe_date + '\'' +
                ", refills='" + refills + '\'' +
                ", followUp_id='" + followUps.toString() + '\'' +
                '}';
    }
}
