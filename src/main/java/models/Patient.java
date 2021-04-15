package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="patient", uniqueConstraints = {@UniqueConstraint(columnNames = {"record_id"})})
public class Patient implements Serializable {
    //Declare private data fields
    @Id
    @Column(name="patient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patient_id;
    @Column(name="lastName")
    private String lastName;
    @Column(name="firstName")
    private String firstName;
    @Column(name="dob")
    private Date dob;
    @Column(name="contact_address")
    private String contact_address;
    @Column(name="contact_email")
    private String contact_email;
    @Column(name="contact_phone")
    private String contact_phone;
    @Column(name="pcp")
    private String pcp;
    @Column(name="record_id")
    private Integer record_id;



    public Patient() {
    }



        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setDob(Date dob) {
            this.dob = dob;
        }

        public void setContact_address(String contact_address) {
            this.contact_address = contact_address;
        }

        public void setContact_email(String contact_email) {
            this.contact_email = contact_email;
        }

        public void setContact_phone(String contact_phone) {
            this.contact_phone = contact_phone;
        }

        public void setPcp(String pcp) {
            this.pcp = pcp;
        }

        public void setPatient_id(Integer patient_id) {
            this.patient_id = patient_id;
        }

        public void setRecord_id(Integer record_id) {
            this.record_id = record_id;
        }


        public String getUser_name() {
            return user_name;
        }

        public String getPassword() {
            return password;
        }

        public String getLastName() {
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public Date getDob() {
            return dob;
        }

        public String getContact_address() {
            return contact_address;
        }

        public String getContact_email() {
            return contact_email;
        }

        public String getContact_phone() {
            return contact_phone;
        }

        public String getPcp() {
            return pcp;
        }

        public Integer getPatient_id() {
            return patient_id;
        }

        public Integer getRecord_id() {
            return record_id;
        }


    @Override
    public String toString(){
        return "Patient{" +
                "patient_id='" + patient_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", dob='" + dob + '\'' +
                ", contact_address='" + contact_address + '\'' +
                ", contact_email='" + contact_email + '\'' +
                ", contact_phone='" + contact_phone + '\'' +
                ", pcp='" + pcp + '\'' +
                ", record_id='" + record_id + '\'' +
                "}";

    }
}
