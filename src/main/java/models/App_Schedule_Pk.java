package models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class App_Schedule_Pk implements Serializable {
    private Integer app_id;
    private Integer staff_id;

    public App_Schedule_Pk(Integer app_id, Integer user_id) {

        this.app_id = app_id;
        this.staff_id = user_id;

    }

    public App_Schedule_Pk() {
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
