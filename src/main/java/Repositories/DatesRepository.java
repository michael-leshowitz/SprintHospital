package Repositories;
import models.Dates;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EntityScan("models.Dates")
public interface DatesRepository extends JpaRepository<Dates, Integer> {

    @Query(value = "SELECT * " +
            "from dates " +
            "where (full_date between adddate(Current_date(), INTERVAL 1 DAY) " +
            "and adddate(Current_date(), INTERVAL 14 DAY))" +
            "and (day_of_week != 7 and day_of_week != 1)",
            nativeQuery = true)
    List<Dates> findNextTwoWeeks();

//    @Query(value = "SELECT * FROM patient WHERE firstName= ?1", nativeQuery = true)
//    List<Patient> findByFirstName(String firstname);
//
//    @Query(value = "SELECT * FROM patient WHERE user_name= ?1", nativeQuery = true)
//    List<Patient> findByUserName(String userName);

//    @Query("select u.userName from User u inner join u.area ar where ar.idArea = :idArea")
    //ToDo : Add query logic for applicaiton
}
