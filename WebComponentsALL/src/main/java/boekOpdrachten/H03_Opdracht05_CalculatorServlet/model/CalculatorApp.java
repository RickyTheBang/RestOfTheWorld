package boekOpdrachten.H03_Opdracht05_CalculatorServlet.model;

public class CalculatorApp {


    public static void main(String[] args) {
        Calculator calculator = new Calculator ();
        int result_plus = calculator.calculate (3,5,"+");
        System.out.println ("result: " +result_plus );
        int result_min = calculator.calculate (3,5,"-");
        System.out.println ("result: " +result_min );
        int result_mult = calculator.calculate (3,5,"*");
        System.out.println ("result: " +result_mult );
        int result_div = calculator.calculate (3,5,"/");
        System.out.println ("result: " +result_div );


    }
}
