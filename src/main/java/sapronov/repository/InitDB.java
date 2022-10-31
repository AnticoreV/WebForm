package sapronov.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class InitDB {
    private static InitDB initDB;
    private InitDB(){}
    public static InitDB getInstance(){
        if(initDB == null){initDB = new InitDB();}
        return initDB;
    }
    public Connection init() throws Exception{
        String url = "jdbc:mysql://localhost/webform";
        String username = "root";
        String password = "H78f6bf6ddes3dr9245";
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        return DriverManager.getConnection(url, username, password);
    }
}
