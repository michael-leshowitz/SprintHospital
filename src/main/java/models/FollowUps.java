package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "followups")
public class FollowUps implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="followUp_id")
    private Integer followUp_id;
    @ManyToMany(fetch = FetchType.LAZY)
    List<Users> users;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "date_id")
    private Dates dates;

    public FollowUps() {
    }


    public Integer getFollowUp_id() {
        return followUp_id;
    }

    public void setFollowUp_id(Integer followUp_id) {
        this.followUp_id = followUp_id;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    @Override
    public String toString() {
        return "followups{" +
                "followUp_id='" + followUp_id + '\'' +
                ", date_id='" + dates.getDate_id() + '\'' +
                '}';
    }
}
