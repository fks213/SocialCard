import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Servlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //Получение json из потока

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Map<String, Object>pageVaribles = new HashMap<String, Object>();
        pageVaribles.put("messages", "Hello");

        //resp.getWriter().println(PageGenerator.instance().getPage("Page.html", pageVaribles));

        resp.setContentType("text/html; charset=UTF-8");
        resp.setStatus(HttpServletResponse.SC_OK);
        //Готовим ответ на корректность пароля и логина
        /*resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        Helper dbHelper = new Helper();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"utf-8\">");
            out.println("<title>Test</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("passwprd: " + dbHelper.checkUser(username));
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }*/
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, Object>pageVaribles = new HashMap<String, Object>();
        pageVaribles.put("messages", "Hello");

        String username = req.getParameter("username");
       // resp.getWriter().println(PageGenerator.instance().getPage("Page.html", pageVaribles));
        PrintWriter out = resp.getWriter();
        out.println(username);
        resp.setContentType("text/html; charset=UTF-8");
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}