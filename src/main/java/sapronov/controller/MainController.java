package sapronov.controller;

import sapronov.model.Request;
import sapronov.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "MainController", value = "/MainController")
public class MainController extends HttpServlet {
    private User user;
    private Request request;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         user = new User(
                req.getParameter("Policy_Number"),
                req.getParameter("Name"),
                req.getParameter("Surname")
         );
         request = new Request(req.getParameter("Area"));
         String req_text = request.getReq();
         String pol_num = user.getPolicyNumber();
         String name = user.getName();
         String surname = user.getSurname();
         try{
            String url = "jdbc:mysql://localhost/webform";
            String username = "root";
            String password = "H78f6bf6ddes3dr9245";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                statement.executeUpdate("INSERT INTO users" +
                        " (policy_number, name, surname) VALUES " +
                        " ('"+pol_num+"', '"+name+"', '"+surname+"')");
                statement.executeUpdate("INSERT INTO requests" +
                        " (data) VALUES " +
                        " ('"+req_text+"')");
                System.out.println("Successful");
                statement.close();
            }
         }
         catch(Exception e){
            System.out.println("Connection failed...");
            System.out.println(e);
         }
    }
}
