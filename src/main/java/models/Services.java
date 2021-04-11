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
    private Integer service_id;
    private String name;
    private Duration duration;
    private Integer billing_id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "services")
    private List<Past_Appointments> past_appointments = new ArrayList<>();

    public Services() {
    }

//    public Services(Builder builder) {
//        this.service_id = builder.service_id;
//        this.name = builder.name;
//        this.duration = builder.duration;
//        this.billing_id = builder.billing_id;
//    }
//
//    public static class Builder{
//        private Integer service_id;
//        private String name;
//        private Duration duration;
//        private Integer billing_id;
//
//        public Builder withServiceID(Integer service_id){
//            this.service_id = service_id;
//            return this;
//        }
//
//        public Builder withName(String name){
//            this.name = name;
//            return this;
//        }
//
//        public Builder withDuration(Duration duration){
//            this.duration = duration;
//            return this;
//        }
//
//        public Builder withBillingID(Integer billing_id){
//            this.billing_id = billing_id;
//            return  this;
//        }
//
//        public Services build(){return new Services(this);}
//    }
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

    public List<Past_Appointments> getPast_appointments() {
        return past_appointments;
    }

    public void setPast_appointments(List<Past_Appointments> past_appointments) {
        this.past_appointments = past_appointments;
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
