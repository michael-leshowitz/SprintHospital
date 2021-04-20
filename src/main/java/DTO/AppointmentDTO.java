package DTO;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;

public class AppointmentDTO {
    @NotNull
    @NotEmpty
    private Integer staff_id;

    @NotNull
    @NotEmpty
    private Integer date_id;

    @NotNull
    @NotEmpty
    private String time;

    public Integer getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Integer staff_id) {
        this.staff_id = staff_id;
    }

    public Integer getDate_id() {
        return date_id;
    }

    public void setDate_id(Integer date_id) {
        this.date_id = date_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
