package classOefeningen.H04.model;

public class CalculatorApp {


    public static void main(String[] args) {
        Calculator calculator = new Calculator ();
        int result_plus = calculator.calculate (3,5,"+");
        System.out.println ("result: " +result_plus );
        int result_min = calculator.calculate (result_plus,5,"-");
        System.out.println ("result: " +result_min );
        int result_mult = calculator.calculate (result_min,5,"*");
        System.out.println ("result: " +result_mult );
        int result_div = calculator.calculate (result_mult,5,"/");
        System.out.println ("result: " +result_div );
       int result_CE= calculator.calculate (result_div,5,"CE");
        System.out.println ("result: " +result_CE );


        System.out.println("All operations");
        for(String s : calculator.getHistory()){
            System.out.println(s);
        }


    }
}
