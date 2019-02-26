import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DAO {

    public void save(Statement statement) {
        Session session = Helper.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(statement);
        transaction.commit();
        session.close();
    }

    public void update(Statement statement){
        Session session = Helper.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(statement);
        transaction.commit();
        session.close();
    }

    public void delete(Statement statement){
        Session session = Helper.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(statement);
        transaction.commit();
        session.close();
    }

    public List getAll(){
        return Helper.getSessionFactory().openSession().createQuery("from statement").list();
    }

    public Statement getStatement(int id){
        Session session = Helper.getSessionFactory().openSession();
        Query query = session.createQuery("from statement where id = :id");
        query.setParameter("id", id);
        List list = query.list();
        Statement statement = (Statement) list.iterator().next();
        session.close();
        return statement;
    }

}
