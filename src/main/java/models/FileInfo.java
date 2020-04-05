package models;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileInfo {
    private Long id;
    private String storageFileName;
    private String originalFileName;
    private Long size;
    private String type;
    private String url;
    private String uploadUser;
    private String state;
    private String extention;
}
