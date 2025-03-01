package digitech.cms.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import digitech.cms.system.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(String name);
}
