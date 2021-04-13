package models;

import java.io.Serializable;

public class App_ScheduleId implements Serializable {
    private Integer app_id;

    private Integer staff_id;

    public App_ScheduleId() {
    }

    public Integer getApp_id() {
        return app_id;
    }

    public void setApp_id(Integer app_id) {
        this.app_id = app_id;
    }

    public Integer getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Integer staff_id) {
        this.staff_id = staff_id;
    }
}
