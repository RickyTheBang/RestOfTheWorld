package boekHoefdstucken.h03.p03;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/HelloWorldSecond")
public class HelloWorldServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println ("hello server? I am a little message, congratulations on finding me");

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
            out.println ("Hello World I am servlet!");
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
