package models;

import com.sun.istack.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Users {
    @Id
    @Column(name="user_id")
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @NotNull
    private long userId;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="disabled")
    private boolean disabled;
    @Column(name="account_expired")
    private boolean account_expired;
    @Column(name="account_locked")
    private boolean account_locked;
    @Column(name="credentials_expired")
    private boolean credentials_expired;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<Role> roles;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isAccountExpired() {
        return account_expired;
    }

    public void setAccountExpired(boolean accountExpired) {
        this.account_expired = accountExpired;
    }

    public boolean isAccountLocked() {
        return account_locked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.account_locked = accountLocked;
    }

    public boolean isCredentialsExpired() {
        return credentials_expired;
    }

    public void setCredentialsExpired(boolean credentialsExpired) {
        this.credentials_expired = credentialsExpired;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
