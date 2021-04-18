package models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int role_id;
    private String role_name;

    @ManyToMany(mappedBy = "roles")
    private List<Users> users;//Guide has this as "Collection"

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int roleId) {
        this.role_id = roleId;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
