
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
    @Modifying
    @Query(value = "INSERT INTO appointments VALUES (NULL, :date, '12:00:00', :staff, :patient,1); ",nativeQuery = true)
    @Transactional
    public void saveAppointment(@Param("date") Integer date,
                            @Param("staff") Integer staff,
                            @Param("patient") Long patient);
}
