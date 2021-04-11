package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Departments implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dept_id;
    private String dept_name;
    private String address;
    private String classification;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "departments")
    private List<Appointments> appointments = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "departments")
    private List<Past_Appointments> past_appointments = new ArrayList<>();

    public Departments() {
    }

//    public Departments(Builder builder) {
//        this.dept_id = builder.dept_id;
//        this.dept_name = builder.dept_name;
//        this.address = builder.address;
//        this.classification = builder.classification;
//    }
//
//
//    public static class Builder{
//        private Integer dept_id;
//        private String dept_name;
//        private String address;
//        private String classification;
//
//        public Builder withDeptID(Integer dept_id){
//            this.dept_id = dept_id;
//            return this;
//        }
//
//        public Builder withDeptName(String dept_name){
//            this.dept_name = dept_name;
//            return this;
//        }
//
//        public Builder withAddress(String address){
//            this.address = address;
//            return this;
//        }
//
//        public Builder withClassification(String classification){
//            this.classification = classification;
//            return this;
//        }
//
//        public Departments build(){return new Departments(this);}
//    }
    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public List<Appointments> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointments> appointments) {
        this.appointments = appointments;
    }

    public List<Past_Appointments> getPast_appointments() {
        return past_appointments;
    }

    public void setPast_appointments(List<Past_Appointments> past_appointments) {
        this.past_appointments = past_appointments;
    }

    @Override
    public String toString() {
        return "departments{" +
                "dept_id='" + dept_id + '\'' +
                ", dept_name='" + dept_name + '\'' +
                ", address='" + address + '\'' +
                ", classification='" + classification + '\'' +
                '}';
    }
}
