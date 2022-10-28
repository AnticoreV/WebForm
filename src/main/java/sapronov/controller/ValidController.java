package sapronov.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "ValidController", value = "/main-view")
public class ValidController extends HttpServlet {
    //policy_number requires minimum 8 characters
    private boolean isValidLength(String pass){
        if(pass.length() < 8){
            return false;
        }else return true;
    }
    //policy_number requires minimum 1 small/big letter, 1 number
    private boolean isValidSymbols(String pass){
        int letter = 0, number = 0, big_letter = 0;
        for(int i = 0; i < pass.length(); i++){
            if(pass.charAt(i) > 47 && pass.charAt(i) < 58){number++;}
            else if (pass.charAt(i) > 96 && pass.charAt(i) < 123) {letter++;}
            else if (pass.charAt(i) > 64 && pass.charAt(i) < 91) {big_letter++;}
            else return false;
            }
        if(letter == 0 || number == 0 || big_letter == 0){
            return false;
        }
        return true;
        }
    //name and surname contains only letters
    private boolean isValidSymbols(String name, String surname){
        if(name == null || surname == null)return false;
        for(int i = 0; i < name.length(); i++){
            if (name.charAt(i) > 96 && name.charAt(i) < 123) {}
            else if (name.charAt(i) > 64 && name.charAt(i) < 91) {}
            else return false;
        }
        for(int i = 0; i < surname.length(); i++){
            if (surname.charAt(i) > 96 && surname.charAt(i) < 123) {}
            else if (surname.charAt(i) > 64 && surname.charAt(i) < 91) {}
            else return false;
        }
        return true;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        if(!(isValidLength(req.getParameter("Policy_Number"))
                && (isValidSymbols(req.getParameter("Policy_Number")))
                && (isValidSymbols(req.getParameter("Name"), req.getParameter("Surname"))))){
            requestDispatcher = req.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(req, resp);
        }
        requestDispatcher = req.getRequestDispatcher("/MainController");
        requestDispatcher.forward(req, resp);
    }
}
