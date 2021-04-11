package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "staff", uniqueConstraints = {@UniqueConstraint(columnNames = {"userName"})})
public class Staff implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer staff_id;
    private String userName;
    private String password;
    private String lastName;
    private String firstName;
    private String contact_address;
    private String contact_email;
    private String contact_phone;
    private Integer dept_id;
    private String title;
    private Integer permission_level;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "staff")
    private List<Appointments> appointments = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "staff")
    private List<FollowUps> followups = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "staff")
    private List<Past_Appointments> past_appointments = new ArrayList<>();

    public Staff() {
    }

//    public Staff(Builder builder){
//        this.staff_id = builder.staff_id;
//        this.userName = builder.userName;
//        this.password = builder.password;
//        this.lastName = builder.lastName;
//        this.firstName = builder.firstName;
//        this.contact_address = builder.contact_address;
//        this.contact_email = builder.contact_email;
//        this.contact_phone = builder.contact_phone;
//        this.dept_id = builder.dept_id;
//        this.title = builder.title;
//        this.permission_level = builder.permission_level;
//    }
//
//    public static class Builder{
//        private Integer staff_id;
//        private String userName;
//        private String password;
//        private String lastName;
//        private String firstName;
//        private String contact_address;
//        private String contact_email;
//        private String contact_phone;
//        private Integer dept_id;
//        private String title;
//        private Integer permission_level;
//
//        public Builder withStaffID(Integer staff_id){
//            this.staff_id = staff_id;
//            return this;
//        }
//
//        public Builder withUserName(String userName){
//            this.userName = userName;
//            return this;
//        }
//
//        public Builder withPassword(String password){
//            this.password = password;
//            return  this;
//        }
//
//        public Builder withLastName(String lastName){
//            this.lastName = lastName;
//            return this;
//        }
//
//        public  Builder withFirstName(String firstName){
//            this.firstName = firstName;
//            return this;
//        }
//
//        public Builder withContactAddress(String contact_address){
//            this.contact_address = contact_address;
//            return this;
//        }
//
//        public Builder withContactPhone(String contact_phone){
//            this.contact_phone = contact_phone;
//            return this;
//        }
//
//        public Builder withContactEmail(String contact_email){
//            this.contact_email = contact_email;
//            return this;
//        }
//
//        public Builder withDeptID(Integer dept_id){
//            this.dept_id = dept_id;
//            return this;
//        }
//
//        public Builder withTitle(String title){
//            this.title = title;
//            return this;
//        }
//
//        public Builder withPermissionLevel(Integer permission_level){
//            this.permission_level = permission_level;
//            return this;
//        }
//
//        public Staff build(){return new Staff(this);}
//    }

    public Integer getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Integer staff_id) {
        this.staff_id = staff_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getContact_address() {
        return contact_address;
    }

    public void setContact_address(String contact_address) {
        this.contact_address = contact_address;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPermission_level() {
        return permission_level;
    }

    public void setPermission_level(Integer permission_level) {
        this.permission_level = permission_level;
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

    @Override
    public String toString(){
        return "Staff{" +
                "staff_id='" + staff_id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", contact_address='" + contact_address + '\'' +
                ", contact_email='" + contact_email + '\'' +
                ", contact_phone='" + contact_phone + '\'' +
                ", dept_id='" + dept_id + '\'' +
                ", title='" + title + '\'' +
                ", permission_level='" + permission_level + '\'' +
                "}";
    }
}
