package GoKapture.task.management.system.Repositories;

import GoKapture.task.management.system.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
