public class StatementService {
    private DAO statementDao = new DAO();

    public void saveStatement(Statement statement){ statementDao.save(statement); }

    public void updateStatement(Statement statement){
        statementDao.update(statement);
    }

    public void deleteStatement(Statement statement){ statementDao.delete(statement); }

    public void getAllStatements(){ statementDao.getAll(); }

    public Statement getSttement(int id){ return statementDao.getStatement(id); }
}
