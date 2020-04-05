package services;

import dto.SignUpDto;

public interface LoginService {
    boolean login(SignUpDto form);
}
