package classOefeningen.H04.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomDispatcher {

    private List<String > servletsPaths = new ArrayList<> ();
    {        servletsPaths.add ("WEB-INF/pages/classOefeningen/helloSessionServlet.jsp");
        servletsPaths.add ("WEB-INF/pages/classOefeningen/helloJSPServlet.jsp");
        servletsPaths.add ("WEB-INF/pages/classOefeningen/helloCalculatorServlet.jsp");
    }


    public String getADispatcher(){

        String disp = null;

        Random ran = new Random ();
        int index = ran.nextInt (3);
        disp = servletsPaths.get (index);

        return disp;

    }
}


