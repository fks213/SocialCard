import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Helper {
    private static SessionFactory dbSession;

    public static SessionFactory getSessionFactory() {
        if (dbSession == null) {
            Configuration conf = new Configuration().configure("/hibernate.cfg.xml");
            conf.addAnnotatedClass(Statement.class);
            conf.addAnnotatedClass(Document.class);
            conf.addAnnotatedClass(PersonalData.class);
            conf.addAnnotatedClass(Users.class);

            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
            dbSession = conf.buildSessionFactory(builder.build());
        }

        return dbSession;
    }

    public String addUser(String login, String passwd)
    {
        Session session = null;
        if (dbSession == null) {
            dbSession = getSessionFactory();
        }
        session = dbSession.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Users user = new Users();
            user.setLogin(login);
            user.setPasswd(passwd);
            session.save(user);
            transaction.commit();
        }
        catch (HibernateException ex) {
            if(transaction != null)
                transaction.rollback();
            ex.printStackTrace();
            return "Insertion failed!";
        }
        finally {
            session.close();
        }
        return "Success added!";
    }

    public String checkUser(String login) {
        Session session = null;
        if (dbSession == null) {
            dbSession = getSessionFactory();
        }
        session = dbSession.openSession();
        try {
            Query query = session.createQuery("from Users where login = :log");
            query.setParameter("log", login);
            List users = query.list();
            if(users.size() == 0)
                return "No data found!";
            Users user = (Users) users.iterator().next();
            return "password: " + user.getPasswd();
        }
        catch (HibernateException ex) {
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return "Fatal error! No connection!";
    }
}
