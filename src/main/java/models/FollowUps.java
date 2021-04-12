package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "followups")
public class FollowUps implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="followUp_id")
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
