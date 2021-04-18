package models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="services")
public class Services implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="service_id")
    private Integer service_id;
    @Column(name="name")
    private String name;
    @Column(name="duration")
    private Duration duration;
    @Column(name="billing_id")
    private Integer billing_id;


    public Services() {
    }


    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Integer getBilling_id() {
        return billing_id;
    }

    public void setBilling_id(Integer billing_id) {
        this.billing_id = billing_id;
    }




    @Override
    public String toString() {
        return "services{" +
                "service_id='" + service_id + '\'' +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", billing_id='" + billing_id + '\'' +
                '}';
    }
}
