package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "medications")
public class Medications implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medication_id;
    private String name;

//    public Medications(Builder builder) {
//        this.medication_id = builder.medication_id;
//        this.name = builder.name;
//    }

    public Medications() {
    }

//    public static class Builder{
//        private Integer medication_id;
//        private String name;
//
//        public Builder withMedicationID(Integer medication_id){
//            this.medication_id = medication_id;
//            return this;
//        }
//
//        public Builder withName(String name){
//            this.name = name;
//            return this;
//        }
//
//        public Medications build(){return new Medications(this);}
//    }
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
