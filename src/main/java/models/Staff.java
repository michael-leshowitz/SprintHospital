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
    @Column(name="staff_id")
    private Integer staff_id;
    @Column(name="userName")
    private String userName;
    @Column(name="password")
    private String password;
    @Column(name="lastName")
    private String lastName;
    @Column(name="firstName")
    private String firstName;
    @Column(name="contact_address")
    private String contact_address;
    @Column(name="contact_email")
    private String contact_email;
    @Column(name="contact_phone")
    private String contact_phone;
    @Column(name="dept_id")
    private Integer dept_id;
    @Column(name="title")
    private String title;
    @Column(name="permission_level")
    private Integer permission_level;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "staff")
    private List<Appointments> appointments = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "staff")
    private List<FollowUps> followups = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "staff")
    private List<Past_Appointments> past_appointments = new ArrayList<>();

    public Staff() {
    }


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
