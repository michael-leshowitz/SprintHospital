package Repositories;

import java.util.List;

import models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<Users, Integer>{

    @Query("SELECT u FROM Users u join u.roles r WHERE u.username = :username and r.roleName='USER'")
    public List<Users> findUser(@Param("username") String username);

    @Query("SELECT u FROM Users u join u.roles r WHERE u.username = :username and r.roleName='ADMIN'")
    public List<Users> findAdmin(@Param("username") String username);

}
