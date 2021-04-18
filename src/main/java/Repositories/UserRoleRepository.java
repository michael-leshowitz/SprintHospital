package Repositories;

import models.FollowUps;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<FollowUps, Integer> {
}
