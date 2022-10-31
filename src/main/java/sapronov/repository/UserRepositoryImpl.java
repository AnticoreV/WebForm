package sapronov.repository;


import java.sql.Statement;

public class UserRepositoryImpl implements UserRepository{

    InitDB initDB = InitDB.getInstance();
    @Override
    public void saveUser(String pol_num, String name, String surname) throws Exception {
        Statement statement = initDB.init().createStatement();
        statement.executeUpdate("INSERT INTO users" +
                " (policy_number, name, surname) VALUES " +
                " ('"+pol_num+"', '"+name+"', '"+surname+"')");
    }

    @Override
    public void saveRequest(String req_text) throws Exception {
        Statement statement = initDB.init().createStatement();
        statement.executeUpdate("INSERT INTO requests" +
                " (data) VALUES " +
                " ('"+req_text+"')");
    }
}
