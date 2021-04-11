package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "dates")
public class Dates implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer date_id;
    @Temporal(TemporalType.DATE)
    private Date full_date;
    private Integer day_of_week;
    private Boolean isHoliday;
    private Boolean isWeekend;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "dates")
    private List<Appointments> appointments = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "dates")
    private List<FollowUps> followups = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "dates")
    private List<Past_Appointments> past_appointments = new ArrayList<>();

    public Dates() {
    }

//    public Dates(Builder builder) {
//        this.date_id = builder.date_id;
//        this.full_date = builder.full_date;
//        this.day_of_week = builder.day_of_week;
//        this.isHoliday = builder.isHoliday;
//        this.isWeekend = builder.isWeekend;
//    }
//
//    public static class Builder{
//        private Integer date_id;
//        private Date full_date;
//        private Integer day_of_week;
//        private Boolean isHoliday;
//        private Boolean isWeekend;
//
//        public Builder withDateID(Integer date_id){
//            this.date_id = date_id;
//            return  this;
//        }
//
//        public Builder withFullDate(Date full_date){
//            this.full_date = full_date;
//            return  this;
//        }
//
//        public Builder withDayOfWeek(Integer day_of_week){
//            this.day_of_week = day_of_week;
//            return  this;
//        }
//
//        public Builder withIsHoliday(Boolean isHoliday){
//            this.isHoliday = isHoliday;
//            return  this;
//        }
//
//        public Builder withIsWeekend(Boolean isWeekend){
//            this.isWeekend = isWeekend;
//            return  this;
//        }
//
//        public Dates build(){return new Dates(this);}
//    }

    public Integer getDate_id() {
        return date_id;
    }

    public void setDate_id(Integer date_id) {
        this.date_id = date_id;
    }

    public Date getFull_date() {
        return full_date;
    }

    public void setFull_date(Date full_date) {
        this.full_date = full_date;
    }

    public Boolean getHoliday() {
        return isHoliday;
    }

    public void setHoliday(Boolean holiday) {
        isHoliday = holiday;
    }

    public Boolean getWeekend() {
        return isWeekend;
    }

    public void setWeekend(Boolean weekend) {
        isWeekend = weekend;
    }

    public Integer getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(Integer day_of_week) {
        this.day_of_week = day_of_week;
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
        return "dates{" +
                "date_id='" + date_id + '\'' +
                ", full_date='" + full_date + '\'' +
                ", day_of_week='" + day_of_week + '\'' +
                ", isHoliday='" + isHoliday + '\'' +
                ", isWeekend='" + isWeekend + '\'' +
                '}';
    }
}
