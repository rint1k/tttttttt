package repositories;

import models.FileInfo;

import java.util.Optional;

public interface FilesRepository extends CrudRepository<Long, FileInfo> {
    Optional<FileInfo> findFileByName(String name);
}
