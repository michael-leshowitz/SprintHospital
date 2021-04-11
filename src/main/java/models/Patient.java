package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="patient", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_name","record_id"})})
public class Patient implements Serializable {
    //Declare private data fields
    @Id
    @Column(name="patient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patient_id;
    private String user_name;
    private String password;
    private String lastName;
    private String firstName;
    private Date dob;
    private String contact_address;
    private String contact_email;
    private String contact_phone;
    private String pcp;
    private Integer record_id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "patient")
    private List<Appointments> appointments = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "patient")
    private List<FollowUps> followups = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "patient")
    private List<Past_Appointments> past_appointments = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "patient")
    private List<Treatments> treatments = new ArrayList<>();

    public Patient() {
    }

    //    //Declare DB attributes
//    public static final String USER_NAME = "user_name";
//    public static final String PASS_WORD = "password";
//    public static final String LAST_NAME = "lastName";
//    public static final String FIRST_NAME = "firstName";
//    public static final String DOB = "dob";
//    public static final String CONTACT_ADDRESS ="contact_address";
//    public static final String CONTACT_EMAIL ="contact_email";
//    public static final String CONTACT_PHONE="contact_phone";
//    public static final String PCP ="pcp";
//    public static final String BILLING_ID = "billing_id";
//    public static final String PATIENT_ID = "patient_id";
//    public static final String RECORD_ID = "record_id";

//    public Patient(Builder builder){
//        this.patient_id = builder.patient_id;
//        this.user_name = builder.user_name;
//        this.password = builder.password;
//        this.lastName = builder.lastName;
//        this.firstName = builder.firstName;
//        this.dob = builder.dob;
//        this.contact_address = builder.contact_address;
//        this.contact_email = builder.contact_email;
//        this.contact_phone = builder.contact_phone;
//        this.pcp = builder.pcp;
//        this.billing_id = builder.billing_id;
//        this.record_id = builder.record_id;
//    }
//
//    public Patient() {
//    }
//
//    public static class Builder {
//        private String user_name;
//        private String password;
//        private String lastName;
//        private String firstName;
//        private Date dob;
//        private String contact_address;
//        private String contact_email;
//        private String contact_phone;
//        private String pcp;
//        private Integer billing_id;
//        private Integer patient_id;
//        private Integer record_id;
//
//        public Builder withPatientID(Integer patient_id) {
//            this.patient_id = patient_id;
//            return this;
//        }
//
//        public Builder withUserName(String user_name) {
//            this.user_name = user_name;
//            return this;
//        }
//
//        public Builder withPassword(String password) {
//            this.password = password;
//            return this;
//        }
//
//        public Builder withLastName(String lastName) {
//            this.lastName = lastName;
//            return this;
//        }
//
//        public Builder withFistName(String firstName) {
//            this.firstName = firstName;
//            return this;
//        }
//
//        public Builder withDOB(Date dob) {
//            this.dob = dob;
//            return this;
//        }
//
//        public Builder withContactAddress(String contact_address) {
//            this.contact_address = contact_address;
//            return this;
//        }
//
//        public Builder withContactEmail(String contact_email) {
//            this.contact_email = contact_email;
//            return this;
//        }
//
//        public Builder withContactPhone(String contact_phone) {
//            this.contact_phone = contact_phone;
//            return this;
//        }
//
//        public Builder withPCP(String pcp) {
//            this.pcp = pcp;
//            return this;
//        }
//
//        public Builder withBillingID(Integer billing_id) {
//            this.billing_id = billing_id;
//            return this;
//        }
//
//        public Builder withRecordID(Integer record_id) {
//            this.record_id = record_id;
//            return this;
//        }
//
//        public Patient build(){return new Patient(this);}
//    }

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

    public List<Appointments> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointments> appointments) {
        this.appointments = appointments;
    }

    public List<FollowUps> getFollowups() {
        return followups;
    }

    public void setFollowups(List<FollowUps> followups) {
        this.followups = followups;
    }

    public List<Past_Appointments> getPast_appointments() {
        return past_appointments;
    }

    public void setPast_appointments(List<Past_Appointments> past_appointments) {
        this.past_appointments = past_appointments;
    }

    public List<Treatments> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<Treatments> treatments) {
        this.treatments = treatments;
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
