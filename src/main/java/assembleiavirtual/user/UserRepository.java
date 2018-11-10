package assembleiavirtual.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmailAndPasswordHash(String email, String passwordHash);

}
