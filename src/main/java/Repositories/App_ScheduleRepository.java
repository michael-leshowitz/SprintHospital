package Repositories;
import models.App_Schedule;
import models.App_ScheduleId;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
@EntityScan("models.App_Schedule")
public interface App_ScheduleRepository extends JpaRepository<App_Schedule, App_ScheduleId> {

//    @Query(value = "SELECT * FROM patient WHERE firstName= ?1", nativeQuery = true)
//    List<Patient> findByFirstName(String firstname);
//
//    @Query(value = "SELECT * FROM patient WHERE user_name= ?1", nativeQuery = true)
//    List<Patient> findByUserName(String userName);

//    @Query("select u.userName from User u inner join u.area ar where ar.idArea = :idArea")
    //ToDo : Add query logic for applicaiton
}
