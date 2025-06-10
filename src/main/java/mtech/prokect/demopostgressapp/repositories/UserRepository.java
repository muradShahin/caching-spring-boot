package mtech.prokect.demopostgressapp.repositories;

import mtech.prokect.demopostgressapp.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
}
