package repositories;

import models.User;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<Long, User> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
