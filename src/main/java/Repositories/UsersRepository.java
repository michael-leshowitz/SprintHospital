package Repositories;

import java.util.List;

import models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{


    @Query("SELECT u FROM Users u join u.roles r WHERE u.username = :username and r.role_name='USER'")
    public List<Users> findUser(@Param("username") String username);

    @Query("SELECT u FROM Users u join u.roles r WHERE u.username = :username and r.role_name='ADMIN'")
    public List<Users> findAdmin(@Param("username") String username);

    @Modifying
    @Query(value = "INSERT INTO users VALUES (NULL, :username, :password, :email, '0','0','0','0', :firstName, :lastName); ",nativeQuery = true)
    @Transactional
    public void savePatient(@Param("username") String username, @Param("password") String password, @Param("email") String email, @Param("firstName") String firstName, @Param("lastName") String lastName);

    @Modifying
    @Query(value="insert into user_role (user_role.user_id, user_role.role_id) values ((Select max(users.user_id) from users), 2)", nativeQuery = true)
    public void updateUserRole();
}
