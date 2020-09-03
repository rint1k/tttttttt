package repositories;

import models.FileInfo;
import models.Message;
import models.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

    //language=SQL
    private final String FIND_MESSAGE_BY_AUTHOR_SQL = "select * from support_message where auhor = ?";
    //language=SQL
    private final String FIND_ALL_MESSAGES_SQL = "select * from support_message";
    //language=SQL
    private final String FIND_MESSAGE_BY_ID_SQL = "select * from support_message where id = ?";
    //language=SQL
    private final String INSERT_MESSAGE = "insert into support_message (author, content, message_type) values (?, ?, ?)";

    private RowMapper<Message> messageRowMapper = (row, rowNumber) -> Message.builder()
            .id(row.getLong("id"))
            .sender(row.getString("author"))
            .content(row.getString("content"))
            .messageType(MessageType.valueOf(row.getString("message_type")))
            .build();

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Optional<Message> find(Long aLong) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_MESSAGE_BY_ID_SQL, new Object[]{aLong}, messageRowMapper));
    }

    @Override
    public List<Message> findAll() {
        return jdbcTemplate.query(FIND_ALL_MESSAGES_SQL, messageRowMapper);
    }

    @Override
    public void save(Message entity) {
        jdbcTemplate.update(INSERT_MESSAGE, entity.getSender(), entity.getContent(), entity.getMessageType());
    }

    @Override
    public void delete(Long aLong) {

    }
}
