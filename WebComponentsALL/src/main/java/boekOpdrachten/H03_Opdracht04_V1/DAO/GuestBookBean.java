package boekOpdrachten.H03_Opdracht04_V1.DAO;

import java.io.Serializable;
import java.sql.Date;

public class GuestBookBean implements Serializable {

    private int id;
    private Date date;
    private String name;
    private String message;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "GuestBookBean{" +
                "id=" + id +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
