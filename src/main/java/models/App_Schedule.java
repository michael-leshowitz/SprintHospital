package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "app_schedule")
//@IdClass(App_Schedule_Pk.class)
public class App_Schedule implements Serializable {
//    @AttributeOverrides({
//            @AttributeOverride(name="app_id", column = @Column(name="app_id"))
//
//            @AttributeOverride(name="staff_id", column = @Column(name="staff_id"))
//    })
   @EmbeddedId
   private App_Schedule_Pk app_schedule_pk;

   @MapsId("app_id")
    @ManyToOne
    @JoinColumn(name = "app_id", referencedColumnName = "app_id")
    private Appointments appointments;

    @MapsId("staff_id")
    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "user_id")
    private Users user;

    public App_Schedule() {
    }


    public Appointments getAppointments() {
        return appointments;
    }

    public void setAppointments(Appointments appointments) {
        this.appointments = appointments;
    }


    @Override
    public String toString(){
        return "app_schedule{" +
                "app_id='" + appointments.getApp_id() + '\'' +
                '}';
    }
}
