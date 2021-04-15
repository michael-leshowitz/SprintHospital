//package Repositories;
//
//import models.Patient;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//@EntityScan("models.Patient")
//public interface PatientRepository extends JpaRepository<Patient, Integer> {
//
//    @Query(value = "SELECT * FROM patient WHERE user_name= ?1", nativeQuery = true)
//    Patient findByUserName(String user_name);
//
//    @Query(value = "SELECT * FROM patient WHERE contact_email= ?1", nativeQuery = true)
//    Patient findByContactEmail(String contact_email);
//
//   @Query(value = "SELECT * FROM patient WHERE firstName= ?1", nativeQuery = true)
//    List<Patient> findByFirstName(String firstname);
//
//    @Query(value = "SELECT * FROM patient WHERE user_name= ?1", nativeQuery = true)
//    List<Patient> findAllByUserName(String userName);
//
//}
