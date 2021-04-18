package DTO;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;

public class UserDTO {
    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String matchingPassword;

    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    private boolean disabled;
    private boolean account_expired;
    private boolean account_locked;
    private boolean credentials_expired;

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

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
