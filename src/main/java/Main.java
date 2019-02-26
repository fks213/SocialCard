import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletContext;

public class Main {
    public static void main(String[] args) throws Exception  {
        Helper dataBase = new Helper();
        //System.out.println(dataBase.addUser("admin","576923"));
        System.out.println(dataBase.checkUser("admin"));
        StatementService ss = new StatementService();
        Document doc = new Document("Test document", "test");
        PersonalData data = new PersonalData("123456", "1234", "123-123-123");
        Statement statement = new Statement();
        doc.addStatement(statement);
        statement.setDocument(doc);
        data.addStatement(statement);
        statement.setPersonaldata(data);
        ss.saveStatement(statement);
        System.out.println("Statement saved");
        /*Servlet servlet = new Servlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(servlet), "/test");

        Server server = new Server(8080);
        server.setHandler(context);

        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            System.out.println("ALARM");
            ex.printStackTrace();
        }*/
    }
}
