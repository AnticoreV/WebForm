package sapronov.controller;

import sapronov.util.ValidationUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "ValidController", value = "/main-view")
public class ValidController extends HttpServlet {
    ValidationUtil valid = ValidationUtil.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        if(!(valid.isMinValidLength(req.getParameter("Policy_Number"),8)
                && (valid.isValidSymbols(req.getParameter("Policy_Number")))
                && (valid.isValidSymbols(req.getParameter("Name"), req.getParameter("Surname")))
                && valid.isMaxValidLength(req.getParameter("Area"), 5000))){
            requestDispatcher = req.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(req, resp);
        }
        requestDispatcher = req.getRequestDispatcher("/MainController");
        requestDispatcher.forward(req, resp);
    }
}
