package classOefeningen;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Bart3oefeningen")
public class Bart3oefeningen extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        response.setContentType ("text/html");
        response.setCharacterEncoding ("UTF-8");

        //1) Verander de context naar goodbye
        //2) Generate a random name
        GenerateRandomNames gen = new GenerateRandomNames ( );
        String theName = gen.giveName ( );
        //3) Read Request object
        String tagsBefore = "&lt build &gt  &lt finalName  &gt  WebcomponentsALL &lt /finalName  &gt &lt /build &gt";
        String tagsAfter = "&lt build  &gt   &lt finalName  &gt goodbye &lt /finalName  &gt &lt /build &gt";
        String requestHeader = request.toString ( );

        try (PrintWriter out = response.getWriter ( )) {
            out.println ("<!DOCTYPE html");
            out.println ("<html>");
            out.println ("<head>");
            out.println ("<title>3 Oefeningen van bart</title>");
            out.println ("</head>");
            out.println ("<body>");
            out.println ("<h1>");
            out.println ("3 Oefeningen van bart");
            out.println ("</h1>");
            out.println ("<h2>");
            out.println ("1) Verander de context naar goodbye");
            out.println ("</h2>");
            out.println ("<p>");
            out.print ("Verander de inhoud van de hieronder tags");
            out.println ("</p>");
            out.println ("<p><em><strong>");
            out.print (tagsBefore);
            out.println ("</strong></em></p>");
            out.println ("<p>");
            out.print ("met de hieronder inhoud");
            out.println ("</p>");
            out.println ("<p><em><strong>");
            out.print (tagsAfter);
            out.println ("</strong></em></p>");
            out.println ("</p>");
            out.println ("<h2>");
            out.println ("2) Generate a random name");
            out.println ("</h2>");
            out.println ("<p>");
            out.println (theName);
            out.println ("</p>");

            out.println ("<button onclick='window.location.reload()'>here</button>");
            out.println ("<p>");
            out.println ("<h2>");
            out.println ("3) Read Request object");
            out.println ("</h2>");
            out.println ("<p>");
            out.println (requestHeader);
            out.println ("</p>");

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
