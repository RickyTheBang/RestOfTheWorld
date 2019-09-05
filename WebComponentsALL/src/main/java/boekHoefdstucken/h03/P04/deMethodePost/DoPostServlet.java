package boekHoefdstucken.h03.P04.deMethodePost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/doPost")
public class DoPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter ("name" );

        response.setContentType ("text/html");
        response.setCharacterEncoding ("UTF-8");
        try (PrintWriter out = response.getWriter ( )) {
            out.println ("<!DOCTYPE html");
            out.println ("<html>");
            out.println ("<head>");
            out.println ("<title>HelloWorldServlet</title>");
            out.println ("</head>");
            out.println ("<body>");
            out.println ("<h1>");
            out.println (name);
            out.println ("</h1>");

            /*Footer begin*/
            out.println ("<footer>");
            out.println ("<p>");
            out.println ("-----------------");
            out.println ("</p>");
            out.println ("   <p><a href=");
            out.println ("index.html>Back to index</a></p>");
            out.println ("<p>");
            out.println ("-----------------");
            out.println ("</p>");
            out.println ("</footer>");
            /*Footer end*/
            out.println ("</body>");
            out.println ("<html>");

        }

    }


}
