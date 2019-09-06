package classOefeningen.H04.model;

public class RandomDispatcherApp {

    public static void main(String[] args) {
        RandomDispatcher rd = new RandomDispatcher ();

        System.out.println (rd.getADispatcher () );

        String a = "1";
        System.out.println (a=="1" );
        a +=2;
        a +='c';
        a += false;
        System.out.println (a );
        System.out.println (a=="12cfalse" );
        System.out.println ( );

    }
}
