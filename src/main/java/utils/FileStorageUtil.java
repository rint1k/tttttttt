package utils;


import models.FileInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@Component
public class FileStorageUtil {
    private String url = "http://localhost:8080/Samatter/files/";

    public FileInfo convertToFileInfo(MultipartFile multipartFile) {
        String originalName = multipartFile.getOriginalFilename();
        long size = multipartFile.getSize();
        String type = multipartFile.getContentType();
        String storageFileName = Random.getRandomName();
        String uploadUser = "hazyaenservica@yandex.ru";
        String state = "Neizvestno";
        String extention = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".") + 1);
        return FileInfo.builder().originalFileName(originalName).size(size).type(type).storageFileName(storageFileName).uploadUser(uploadUser).state(state).extention(extention).url(url + storageFileName).build();
    }
}
