import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Login extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, Object> pageVaribles = new HashMap<String, Object>();
        pageVaribles.put("messages", "Hello");
        resp.getWriter().println(PageGenerator.instance().getPage("login.html", pageVaribles));
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;utf-8");
        PrintWriter out = resp.getWriter();
        String login = req.getParameter("login");
        String passwd = req.getParameter("passwd");

        if(passwd.equals("123")){
            out.println("Welcome " + login + "<br>");
            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            out.println("My session counter: " + getSessionCount(session) + "<br>");
            out.println("Session id: " + session.getId() + "<br>");

            out.println("Session created: " + new Date(session.getCreationTime()));


            int time = 10;
            session.setMaxInactiveInterval(time);
        }
        else {
            out.println("Wrong password!");
        }
        out.close();
    }

    private int getSessionCount(HttpSession session) {
        Integer counter= (Integer)session.getAttribute("counter");

        if(counter == null) {
            session.setAttribute("counter", 1);
            return 1;
        }
        else {
            session.setAttribute("counter", ++counter);
            return counter;
        }
    }
}
