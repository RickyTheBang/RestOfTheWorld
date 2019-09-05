package boekOpdrachten.H03_Opdracht04_V1;
import boekOpdrachten.H03_Opdracht04_V1.DAO.GuestBookBean;
import boekOpdrachten.H03_Opdracht04_V1.DAO.GuestBookDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet()
public class GuestBookServlet extends HttpServlet {
    private GuestBookDaoImpl bookDao ;

    public void init() throws ServletException {
        try {



            String driver = getInitParameter ("driver");
            String url = getInitParameter ("url");
            String user = getInitParameter ("user");
            String password = getInitParameter ("password");

            bookDao = new GuestBookDaoImpl();
            bookDao.setDriver(driver);
            bookDao.setUrl(url);
            bookDao.setUser(user);
            bookDao.setPassword(password);




/*
            bookDao.setDriver ("org.mariadb.jdbc.Driver");
            bookDao.setUrl ("jdbc:mariadb://noelvaes.eu/StudentDB");
            bookDao.setUser ("student");
            bookDao.setPassword ("student123");
*/
        } catch (ClassNotFoundException ex) {
            throw new ServletException ("Unable to initialize DAO ", ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try (PrintWriter out = response.getWriter()) {
            List<GuestBookBean> items = bookDao.getGuestBookItems ();
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");

            out.println("<html><head>");
            out.println("<title>Guestbook</title>");
            out.println("</head><body>");



            for (int i = 0; i < items.size ( ); i++) {
                String message = items.get (i).getMessage ( );
                String name = items.get (i).getName ( );
                out.print ("<p>");
                out.print (name + message);
                out.print ("</p>");
            }
            out.print("<p>something new </p>");
            out.print("<form method='POST' >");
            out.print("Name: ");
            out.print("<input type='text' name='name' /><br />");
            out.print("Message: ");
            out.print("<input type='text' name='message' /><br />");
            out.print("<br/><input type='submit' value='Submit' />");
            out.print("</form></body></html>");
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String message = request.getParameter("message");
        GuestBookBean item = new GuestBookBean();
        item.setDate(new java.sql.Date(System.currentTimeMillis ()) );
        item.setMessage(message);
        item.setName(name);
        bookDao.addGuestBookItem(item);
        log("Message added: " + name + " : " + message);
        response.setContentType ("text/html");
        PrintWriter writer =response.getWriter ();

        writer.println ("Message added: " + name + " : " + message);
        doGet(request, response);


    }



}
