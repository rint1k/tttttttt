package services;

import models.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public interface FilesService {
    Optional<File> find(Long id);
    List<File> findAll();
    FileInfo save(MultipartFile file);
    void delete(Long id);
    Optional<File> findByName(String name);
    public InputStream getInputStreamByName(String filename);
}
