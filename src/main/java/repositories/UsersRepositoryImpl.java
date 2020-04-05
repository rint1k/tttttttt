package repositories;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UsersRepositoryImpl implements UsersRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private RowMapper<User> userRowMapper = (row, rowInt) ->
            User.builder().id(row.getLong("id")).email(row.getString("email")).username(row.getString("username")).password(row.getString("password")).build();

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_SELECT_BY_USERNAME, new Object[]{username}, userRowMapper));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_SELECT_BY_EMAIL, new Object[]{email}, userRowMapper));
    }

    @Override
    public Optional<User> find(Long aLong) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, new Object[]{aLong}, userRowMapper));
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, userRowMapper);
    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update(SQL_INSERT, entity.getUsername(), entity.getEmail(), passwordEncoder.encode(entity.getPassword()));
    }

    @Override
    public void delete(Long aLong) {
        jdbcTemplate.update(SQL_DELETE, aLong);
    }
    private final static String SQL_SELECT_ALL = "select * from user";
    private final static String SQL_SELECT_BY_USERNAME = "select * from user where username = ?";
    private final static String SQL_SELECT_BY_EMAIL = "select * from user where email = ?";
    private final static String SQL_INSERT = "insert into user (username, email, password) value (?, ?, ?) ";
    private final static String SQL_SELECT_BY_ID = "select * from user where id = ?";
    private final static String SQL_DELETE = "delete from user where id = ?";


}
