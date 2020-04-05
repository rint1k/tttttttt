package config.security;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import repositories.UsersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AuthProviderImpl implements AuthenticationProvider {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("Я заглянул в AuthProviderImpl");
        String username = authentication.getName();
        Optional<User> user = usersRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("Пользователь не обнаружен");
        }
        String password = authentication.getCredentials().toString();
        if (!password.equals(user.get().getPassword())) {
        //if (!passwordEncoder.matches(password, user.get().getPassword())) {
            throw new BadCredentialsException("Неверные имя пользователя или пароль!");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        return new UsernamePasswordAuthenticationToken(user.get(), null, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
