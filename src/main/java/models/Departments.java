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
    @Column(name="dept_id")
    private Integer dept_id;
    @Column(name="dept_name")
    private String dept_name;


    public Departments() {
    }

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



    @Override
    public String toString() {
        return "departments{" +
                "dept_id='" + dept_id + '\'' +
                ", dept_name='" + dept_name + '\'' +
                '}';
    }
}
