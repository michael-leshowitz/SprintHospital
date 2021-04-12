package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "medications")
public class Medications implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="medication_id")
    private Integer medication_id;
    @Column(name="name")
    private String name;


    public Medications() {
    }


    public Integer getMedication_id() {
        return medication_id;
    }

    public void setMedication_id(Integer medication_id) {
        this.medication_id = medication_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "medications{" +
                "medication_id='" + medication_id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
