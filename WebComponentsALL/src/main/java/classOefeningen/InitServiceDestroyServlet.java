package classOefeningen;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/InitServiceDestroy",initParams = {@WebInitParam (name="superSecret",
        value ="I like to wear socks in the shower")})
public class InitServiceDestroyServlet extends HttpServlet {
private String secret;
    @Override
    public void init() throws ServletException {
        System.out.println ("this servlet is booting up");
        secret = getInitParameter ("superSecret");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println ("This is a service" );
        resp.getWriter ().println (secret.replace ("s","bl"));
    }

    @Override
    public void destroy() {
        System.out.println ("this servlet will be destroyed now");
    }
}
