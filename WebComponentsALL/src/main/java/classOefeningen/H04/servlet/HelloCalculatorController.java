package classOefeningen.H04.servlet;

import boekOpdrachten.H03_Opdracht05_CalculatorServlet.model.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/HelloCalculator")
public class HelloCalculatorController  extends HttpServlet {private final String RESULT = "CalculatorServlet.result";
    private final String NUMBER = "number";
    private final String CALCULATOR = "calculator";
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


        req.getRequestDispatcher ("WEB-INF/pages/classOefeningen/helloCalculatorServlet.jsp").forward (req,resp);

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
        }
        String numberParameter = req.getParameter (NUMBER);
        if(operation.equals("CE")){
            numberParameter="0";
        }



        if (numberParameter != null ) {
            try {
                result = calculator.calculate (result, Integer.parseInt (numberParameter), operation);

            } catch (NumberFormatException ex) {
                if(!operation.equals("CE")){
                    message = "Invalid number";
                }
            }
        }
        req.setAttribute ("message", message);
       // req.setAttribute ("result", result);
       // req.setAttribute ("calculator", calculator);
        session.setAttribute ("result", result);
        session.setAttribute(CALCULATOR,calculator);
        doGet (req, resp);
    }
}
