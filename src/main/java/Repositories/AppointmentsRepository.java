
package Repositories;
import models.Appointments;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@EntityScan("models.App_Schedule")
public interface AppointmentsRepository extends JpaRepository<Appointments, Integer> {
    @Query(value = "Select * " +
            "from Appointments a join Dates d on a.date_id = d.date_id " +
            "where ((d.full_date < Current_date()) " +
            "OR (d.full_date = Current_date() and a.time < Current_Time())) " +
            "and a.staff_id = :staff", nativeQuery = true)
    public List<Appointments> findPreviousAppointmentsByStaffId(@Param("staff") Long user_id);

    @Query(value = "Select * " +
            "from Appointments a join Dates d on a.date_id = d.date_id " +
            "where d.full_date >=  Current_date() and a.patient_id = :patient",
            nativeQuery = true)
    public List<Appointments> findUpcomingAppointmentByPatientId(@Param("patient") Long patient_id);

    @Query(value = "Select * " +
            "from Appointments a join Dates d on a.date_id = d.date_id " +
            "where d.full_date >=  Current_date() and a.staff_id = :staff",
            nativeQuery = true)
    public List<Appointments> findAdminAppointmentSchedule(@Param("staff") Long patient_id);

    @Query(value="Select * from Appointments where staff_id = :staff and date_id = :date and time = :time", nativeQuery = true)
    public List<Appointments> findAppointmentByStaffDateTime(@Param("staff") Integer user_id, @Param("date") Integer date_id, @Param("time") String time);

    @Modifying
    @Query(value ="DELETE " +
            "FROM appointments " +
            "where app_id = :app " +
            "LIMIT 1",
            nativeQuery = true)
    @Transactional
    public void deleteByAppId(@Param("app") Integer app_id);

    @Modifying
    @Query(value = "INSERT INTO appointments VALUES (NULL, :date, :time, :staff, :patient,1); ",nativeQuery = true)
    @Transactional
    public void saveAppointment(@Param("date") Integer date,
                                @Param("staff") Integer staff,
                                @Param("patient") Long patient,
                                @Param("time") String time);
}
