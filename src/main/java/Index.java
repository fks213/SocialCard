import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Index extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Map<String, Object> pageVaribles = new HashMap<String, Object>();
        pageVaribles.put("messages", "Hello");

        resp.getWriter().println(PageGenerator.instance().getPage("index.html", pageVaribles));
   }
}
