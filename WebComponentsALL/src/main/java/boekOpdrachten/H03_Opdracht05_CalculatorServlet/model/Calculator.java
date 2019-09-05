package boekOpdrachten.H03_Opdracht05_CalculatorServlet.model;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    List<String> history = new ArrayList<> ( );
    {
        history.add ("0");
    }

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }

    public int calculate(int result, int value, String operator) {
        switch (operator) {
            case "+":
                result += value;
                break;
            case "-":
                result -= value;
                break;
            case "*":
                result *= value;
                break;
            case "/":
                result /= value;
                break;
            case "CE":
                result = 0;
        }
if(operator!="CE"){
    this.history.add (operator + "  " + value + " = " +result);
}
     else {
         this.history.clear ();
}
        return result;
    }
}
