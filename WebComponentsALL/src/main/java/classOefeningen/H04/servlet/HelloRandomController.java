package classOefeningen.H04.servlet;

import classOefeningen.H04.model.RandomDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/HelloRandom")
public class HelloRandomController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RandomDispatcher rd = new RandomDispatcher ();
        String dispatcher = rd.getADispatcher ();
        req.getRequestDispatcher (dispatcher).forward (req,resp);
    }
}