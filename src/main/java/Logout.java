import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Logout extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;utf-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        session.invalidate();
        out.println("<script>document.location.href = \"index\";</script>");
        out.close();
    }
}