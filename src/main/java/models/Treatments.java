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
    @Column(name="treatment_id")
    private Integer treatment_id;
    @Column(name="supply")
    private Integer supply;
    @Column(name="dosage")
    private Integer dosage;
    @Column(name="prescribe_date")
    private Date prescribe_date;
    @Column(name="refills")
    private Integer refills;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="patient_id", nullable = false)
    private Users user;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medication_id")
    private Medications medication;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FollowUps> followUps = new ArrayList<>();

    public Treatments() {
    }


    public Integer getTreatment_id() {
        return treatment_id;
    }

    public void setTreatment_id(Integer treatment_id) {
        this.treatment_id = treatment_id;
    }


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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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
                ", medication_id='" + medication.getMedication_id() + '\'' +
                ", supply='" + supply + '\'' +
                ", dosage='" + dosage + '\'' +
                ", prescribe_date='" + prescribe_date + '\'' +
                ", refills='" + refills + '\'' +
                ", followUp_id='" + followUps.toString() + '\'' +
                '}';
    }
}
