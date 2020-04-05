package repositories;

import models.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FilesRepositoryImpl implements FilesRepository {

    //language=SQL
    private final String FIND_FILE_BY_NAME_SQL = "select * from files where name = ?";
    //language=SQL
    private final String FIND_ALL_FILES_SQL = "select * from files";
    //language=SQL
    private final String FIND_FILE_BY_ID_SQL = "select * from files where id = ?";
    //language=SQL
    private final String INSERT_FILE_SQL = "insert into files (`name`, uploadUser, `size`, path, state, `mime-type`, extention, originalName) VALUE (?, ?, ?, ?, ?, ?, ?, ?)";
    //language=SQL
    private final String DELETE_FILE_SQL = "DELETE from files where id = ?";

    private final String urlBegin = "/files/";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<FileInfo> fileInfoRowMapper = (row, rowNumber) -> FileInfo.builder()
            .id(row.getLong("id"))
            .storageFileName(row.getString("name"))
            .originalFileName(row.getString("originalName"))
            .size(row.getLong("size"))
            .type(row.getString("mime-type"))
            .url(urlBegin + row.getString("name")).build();

    @Override
    public Optional<FileInfo> find(Long aLong) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_FILE_BY_ID_SQL, new Object[]{aLong}, fileInfoRowMapper));
    }

    @Override
    public List<FileInfo> findAll() {
        return jdbcTemplate.query(FIND_ALL_FILES_SQL, fileInfoRowMapper);
    }

    @Override
    public void save(FileInfo entity) {
        jdbcTemplate.update(INSERT_FILE_SQL, entity.getStorageFileName(), entity.getUploadUser(), entity.getSize(), entity.getUrl(), entity.getState(), entity.getType(), entity.getExtention(), entity.getOriginalFileName());
    }

    @Override
    public void delete(Long aLong) {
        jdbcTemplate.update(DELETE_FILE_SQL, aLong);
    }

    @Override
    public Optional<FileInfo> findFileByName(String name) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_FILE_BY_NAME_SQL, new Object[]{name}, fileInfoRowMapper));
    }
}
