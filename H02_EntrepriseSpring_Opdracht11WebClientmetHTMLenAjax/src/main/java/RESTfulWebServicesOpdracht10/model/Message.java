package RESTfulWebServicesOpdracht10.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.StringJoiner;

@XmlRootElement
public class Message implements Serializable {
    private int id;
    private String author;
    private String text;


    public Message() {
    }

    public Message(int id, String author, String text) {
        this.id = id;
        this.author = author;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Message.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("author='" + author + "'")
                .add("text='" + text + "'")
                .toString();
    }
}
