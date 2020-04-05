package models;

public class Article {
    private int id;
    private String articleText;
    private String comment;
    private String articleData;
    private String imgLink;
    private String genre;

    public Article(int id, String articleText, String comment, String articleData, String imgLink, String genre) {
        this.id = id;
        this.articleText = articleText;
        this.comment = comment;
        this.articleData = articleData;
        this.imgLink = imgLink;
        this.genre = genre;
    }


    public Article() {
    }

    public Article(String articleText, String comment, String articleData, String imgLink, String genre) {
        this.articleText = articleText;
        this.comment = comment;
        this.articleData = articleData;
        this.imgLink = imgLink;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getArticleData() {
        return articleData;
    }

    public void setArticleData(String articleData) {
        this.articleData = articleData;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
