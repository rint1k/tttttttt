package services;

import models.FileInfo;
import models.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> find(Long id);
    List<User> findAll();
    Optional<User> findByUsername(String username);

}
