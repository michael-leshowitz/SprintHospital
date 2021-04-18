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
    @Column(name="date_id")
    private Integer date_id;
    @Temporal(TemporalType.DATE)
    @Column(name="full_date")
    private Date full_date;
    @Column(name="day_of_week")
    private Integer day_of_week;
    @Column(name="isHoliday")
    private Boolean isHoliday;
    @Column(name="isWeekend")
    private Boolean isWeekend;


    public Dates() {
    }


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
