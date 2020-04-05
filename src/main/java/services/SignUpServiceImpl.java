package services;

import dto.SignUpDto;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repositories.UsersRepository;
import repositories.UsersRepositoryImpl;

@Component
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void signUp(SignUpDto form) {
        usersRepository.save(User.builder().username(form.getUsername()).email(form.getEmail()).password(form.getPassword()).build());
    }
}
