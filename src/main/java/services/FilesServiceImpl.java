package services;

import models.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import repositories.FilesRepository;
import utils.FileStorageUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component(value = "myFilesService")
public class FilesServiceImpl implements FilesService {

    @Autowired
    private FilesRepository filesRepository;
    @Autowired
    private FileStorageUtil fileStorageUtil;

    private String storagePath = "C:\\Users\\kadyr\\Desktop\\Example\\";

    @Override
    public Optional<File> find(Long id) {
        Optional<FileInfo> optionalFileInfo = filesRepository.find(id);
        return optionalFileInfo.map(fileInfo -> new File(storagePath + fileInfo.getStorageFileName()));
    }

    @Override
    public List<File> findAll() {
        List<File> files = new ArrayList<>();
        for (FileInfo fileInfo : filesRepository.findAll()) {
            files.add(new File(storagePath + fileInfo.getOriginalFileName()));
        }
        return files;
    }

    @Override
    public FileInfo save(MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                FileInfo fileInfo = fileStorageUtil.convertToFileInfo(file);
                Files.copy(file.getInputStream(), Paths.get(storagePath, fileInfo.getStorageFileName()));

                filesRepository.save(fileInfo);
                return fileInfo;
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            throw new IllegalArgumentException("Один Бог знает что это " + file.getName());
        }
    }


    @Override
    public void delete(Long id) {
        filesRepository.delete(id);
    }

    public InputStream getInputStreamByName(String filename) {
        try {
            InputStream is = new FileInputStream(findByName(filename).get());
            return is;
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Optional<File> findByName(String name) {
        Optional<FileInfo> optionalFileInfo = filesRepository.findFileByName(name);
        return optionalFileInfo.map(fileInfo -> new File(storagePath + fileInfo.getStorageFileName()));
    }
}
