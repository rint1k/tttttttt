package repositories;

import models.FileInfo;

import java.util.List;
import java.util.Optional;

public interface FilesRepository extends CrudRepository<Long, FileInfo> {
    Optional<FileInfo> findFileByName(String name);
    List<FileInfo> findByOriginalNameOrAuthor(String originalFileName, String author);
}
