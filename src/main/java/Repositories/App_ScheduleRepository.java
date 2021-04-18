package Repositories;
import models.App_Schedule;
import models.App_Schedule_Pk;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EntityScan("models.App_Schedule")
public interface App_ScheduleRepository extends JpaRepository<App_Schedule, App_Schedule_Pk> {

//    @Query(value = "SELECT * FROM patient WHERE firstName= ?1", nativeQuery = true)
//    List<Patient> findByFirstName(String firstname);
//
//    @Query(value = "SELECT * FROM patient WHERE user_name= ?1", nativeQuery = true)
//    List<Patient> findByUserName(String userName);

//    @Query("select u.userName from User u inner join u.area ar where ar.idArea = :idArea")
    //ToDo : Add query logic for applicaiton
}
