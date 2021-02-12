package tej.springboot.security.DemoSpringBootUsersReigstrationLogin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tej.springboot.security.DemoSpringBootUsersReigstrationLogin.model.User;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
    User findByConfirmationToken(String confirmationToken);
}
