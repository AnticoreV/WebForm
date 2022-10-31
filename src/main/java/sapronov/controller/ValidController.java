package sapronov.controller;

import sapronov.service.ValidateService;
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
        ValidateService validateService = new ValidateService();
        if(validateService.isValidData(
                req.getParameter("Policy_Number"),
                req.getParameter("Name"),
                req.getParameter("Surname"),
                req.getParameter("Area"))){
            requestDispatcher = req.getRequestDispatcher("/MainController");
            requestDispatcher.forward(req, resp);
        }
        requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }
}
