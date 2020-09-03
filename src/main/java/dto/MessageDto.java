package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.semestrovaya.model.MessageType;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageDto {

    private Timestamp timestamp;

    private MessageType messageType;

    private String pageId;

    private String author;

    private String text;
}