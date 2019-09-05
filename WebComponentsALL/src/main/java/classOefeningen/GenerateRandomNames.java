package classOefeningen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateRandomNames {

    List<String> names = new ArrayList<> ( );

    {
        names.add ("Lucas");
        names.add ("Liam");
        names.add ("Louis");
        names.add ("Mathis");
        names.add ("Lars");
        names.add ("Vince");
        names.add ("Kobe");
        names.add ("Finn");
        names.add ("Noah");
        names.add ("Emma");
        names.add ("Marie");
        names.add ("Elise");
        names.add ("Julie");
        names.add ("Louise");
        names.add ("Noor");
        names.add ("Lotte");
        names.add ("Fien");
        names.add ("Nina");
        names.add ("Ella");
    }


    public String giveName() {
        Random ran = new Random ( );
        int nbr = ran.nextInt (names.size ( ));
        String name = names.get (nbr);
        return name;
    }
}
