package boekOpdrachten.H03_Opdracht04_V2;

import boekOpdrachten.H03_Opdracht04_V1.DAO.GuestBookBean;
import boekOpdrachten.H03_Opdracht04_V1.DAO.GuestBookDaoImpl;



import java.io.*;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(value = "/GuestBookServlet_V02", initParams = { @WebInitParam(name = "driver", value = "org.mariadb.jdbc.Driver"),
      @WebInitParam(name = "url", value = "jdbc:mariadb://noelvaes.eu/StudentDB"),
      @WebInitParam(name = "user", value = "student"), @WebInitParam(name = "password", value = "student123") })
public class GuestBookServlet extends HttpServlet {
   private GuestBookDaoImpl dao;

   public void init() throws ServletException {
  try {
         String driver = getInitParameter("driver");
         String url = getInitParameter("url");
         String user = getInitParameter("user");
         String password = getInitParameter("password");



         dao = new GuestBookDaoImpl();
         dao.setDriver(driver);
         dao.setUrl(url);
         dao.setUser(user);
         dao.setPassword(password);
      } catch (ClassNotFoundException ex) {
         throw new ServletException("Unable to initialize DAO ", ex);
      }
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      try (PrintWriter out = response.getWriter()) {
         List<GuestBookBean> items = dao.getGuestBookItems ();
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
         dao.addGuestBookItem(item);
         log("Message added: " + name + " : " + message);
         response.setContentType ("text/html");
         PrintWriter writer =response.getWriter ();

         writer.println ("Message added: " + name + " : " + message);
         doGet(request, response);


      }



}
