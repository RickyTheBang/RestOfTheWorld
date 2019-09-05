package boekOpdrachten.H03_Opdracht05_CalculatorServlet.controller;

import boekOpdrachten.H03_Opdracht05_CalculatorServlet.model.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Calculator")
public class CalculatorServlet extends HttpServlet {
    private final String RESULT = "CalculatorServlet.result";
    private final String NUMBER = "number";
    private final String OPERATION = "operation";
    private Calculator calculator = new Calculator ( );
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession ( );
        Object resultAttribute = session.getAttribute (RESULT);
        int result = 0;
        if (resultAttribute != null) {
            result = (int) resultAttribute;
        }

        String message = "";
        Object messageAttribute = req.getAttribute ("message");
        if (messageAttribute != null) {
            message = (String) messageAttribute;
        }

        resp.setContentType ("text/html");
        resp.setCharacterEncoding ("UTF-8");
        try (PrintWriter out = resp.getWriter ( )) {
            out.println ("<html><head>");
            out.println ("<title>Calculator</title>");
            out.println ("</head><body>");
            out.print ("<form method='POST'>");
            out.print (message + "<br/>");
            out.print ("Result: <br/>");
            for(String s :calculator.getHistory () ){
                out.print ( s + "<br/>");
            }




            out.print ("<input type='number' name='number' /><br />");
            out.print ("<button name='operation' type='submit' value='+'>+</button>");
            out.print ("<button name='operation' type='submit' value='-'>-</button>");
            out.print ("<button name='operation' type='submit' value='*'>*</button>");
            out.print ("<button name='operation' type='submit' value='/'>/</button>");
            out.print ("<button name='operation' type='submit' value='CE'>CE</button>");
            out.print ("</form></body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int result = 0;
        String message = "";
        String operation = "";

        HttpSession session = req.getSession ( );
        Object resultAttribute = session.getAttribute (RESULT);
        if (resultAttribute != null) {
            result = (int) resultAttribute;
        }

        Object resultOperation = req.getParameter (OPERATION);
        if (resultOperation != null) {
            operation = (String) resultOperation;
        } else {
            operation = "+";
        }


        String numberParameter = req.getParameter (NUMBER);
        if (numberParameter != null) {
            try {
                result = calculator.calculate (result, Integer.parseInt (numberParameter), operation);

            } catch (NumberFormatException es) {
                message = "Invalid number";
            }
        }
        req.setAttribute ("message", message);
        session.setAttribute (RESULT, result);
        doGet (req, resp);
    }
}
