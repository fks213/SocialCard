import org.hibernate.Session;

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
        HttpSession session = req.getSession(false);
        PrintWriter out = resp.getWriter();
        printPage(out, session, "");
   }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;utf-8");
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        String login = req.getParameter("login");
        String passwd = req.getParameter("passwd");
        Helper db = new Helper();
        String pass = db.checkUser(login);
        if(passwd.equals(pass))
        {
            session.setAttribute("login", login);
            session.setMaxInactiveInterval(1800);
        }
        printPage(out, session, (String)session.getAttribute("login"));
    }

    private void printPage(PrintWriter out, HttpSession session, String text)
    {
        out.print("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"utf-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n" +
                "<title>Social Card Index Page</title>\n" +
                "</head>\n" +
                "<body class=\"bg-dark text-white\">\n" +
                "<div>\n" +
                "<div class=\"container\">\n" +
                "<div class=\"row\">\n" +
                "<div class=\"mx-auto\">\n" +
                "<h1>Welcome to SocialCard Statement System</h1>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>");
        if(session == null || session.getAttribute("login") == null)
        {
            out.print("<div class=\"row\">\n" +
                    "<div class=\"mx-auto\">\n" +
                    "<label>To continue, please, login:</label><br>\n" +
                    "<form method=\"post\">\n" +
                    "<div class=\"form-group\">\n" +
                    "<label for=\"login\">Login:</label>\n" +
                    "<input type=\"text\" class=\"form-control\" name=\"login\" placeholder=\"Enter login\">\n" +
                    "</div>\n" +
                    "<div class=\"form-group\">\n" +
                    "<label for=\"Password\">Password:</label>\n" +
                    "<input type=\"password\" class=\"form-control\" name=\"passwd\" placeholder=\"Password\">\n" +
                    "</div>\n" +
                    "<small id=\"emailHelp\" class=\"form-text text-danger\">Invlid login or password!</small>"+
                    "<button type=\"submit\" class=\"btn btn-primary float-right\">Submit</button>\n" +
                    "</form>\n" +
                    "</div>\n" +
                    "</div>");
        }
        else
        {
            out.print("<div class=\"row\">\n" +
                    "    \t<div class=\"mx-auto\">\n" +
                    "    \t\t<p><span>User: </span><span class=\"text-info\">"+text+"</span><a href=\"logout\">Logout</a></p>\n" +
                    "    \t\t<p><span>Last login: </span><span class=\"text-success\">"+new Date(session.getCreationTime())+"</span></p>\n" +
                    "    \t</div>\n" +
                    "    </div>");
        }
        out.print("</div>\n" +
                "<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n" +
                "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n" +
                "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n" +
                "</body>\n" +
                "</html>");
    }

}
