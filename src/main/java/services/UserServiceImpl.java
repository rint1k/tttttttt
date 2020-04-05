package services;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Optional<User> find(Long id) {
        return usersRepository.find(id);
    }

    @Override
    public List<User> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }
}
