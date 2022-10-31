package sapronov.controller;

import sapronov.model.Request;
import sapronov.model.User;
import sapronov.repository.UserRepositoryImpl;
import sapronov.service.UserService;

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

        UserService userService = new UserService();
        try {
            userService.save(pol_num, name, surname);
            userService.save(req_text);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher requestDispatcher;
        requestDispatcher = req.getRequestDispatcher("/view/welcome.jsp");
        requestDispatcher.forward(req, resp);
    }
}
