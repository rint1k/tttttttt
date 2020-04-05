package services;

import dto.SignUpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repositories.UsersRepository;

@Component
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public boolean login(SignUpDto form) {
        return usersRepository.findByUsername(form.getUsername()).isPresent();
    }
}
