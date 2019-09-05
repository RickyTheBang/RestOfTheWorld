package boekOpdrachten.H03_Opdracht04_V1.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestBookDaoImpl implements GuestBookDao {
    private String url;
    private String user;
    private String password;

    public GuestBookDaoImpl(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public GuestBookDaoImpl(){

    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDriver(String driver) throws ClassNotFoundException {
        Class.forName(driver);
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public List<GuestBookBean> getGuestBookItems() {
        String sql = "SELECT * FROM GuestBook";
        List<GuestBookBean> guestBookBeans = new ArrayList<> ( );
        try (Connection con = getConnection ( );
             Statement stmt = con.createStatement ( );
             ResultSet rs = stmt.executeQuery (sql);
        ) {
            while (rs.next ( )) {
                GuestBookBean book = new GuestBookBean ( );
                book.setId (rs.getInt ("Id"));
                book.setDate (rs.getDate ("date"));
                book.setName (rs.getString ("name"));
                book.setMessage (rs.getString ("message"));
                guestBookBeans.add (book);

            }


        } catch (SQLException e) {
            e.printStackTrace ( );
        } catch (ClassNotFoundException e) {
            e.printStackTrace ( );
        }

        return guestBookBeans;
    }

    @Override
    public void addGuestBookItem(GuestBookBean item) {
        try (Connection con = getConnection();
             PreparedStatement stmt = con
                     .prepareStatement (
                             " INSERT INTO GuestBook(Date,Name,Message) VALUES ( ?, ?, ? )");) {

            stmt.setDate (1, new java.sql.Date(System.currentTimeMillis ()));
            stmt.setString (2, item.getName ( ));
            stmt.setString (3, item.getMessage ( ));
            stmt.execute();


        } catch (SQLException e) {
            e.printStackTrace ( );
        } catch (ClassNotFoundException e) {
            e.printStackTrace ( );
        }
    }

    // Private helper methods
    private Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName ("org.mariadb.jdbc.Driver");
        return DriverManager.getConnection (url, user, password);
    }
}
