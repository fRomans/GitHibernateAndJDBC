package servlets;

import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(urlPatterns = "/users/delete", name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {

    private UserService service = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        RequestDispatcher dispatcher = req.getRequestDispatcher("/deleteUser.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       // RequestDispatcher dispatcher;
        try {
            Integer id = Integer.parseInt(req.getParameter("id"));
//            dispatcher = req.getRequestDispatcher("/deleteUser.jsp");
//            dispatcher.forward(req, resp);
            service.deleteUser(service.getUserById(id));
            resp.sendRedirect("/users");
        } catch (SQLException | NullPointerException e) {
            System.out.println("DeleteServlet исключение " + e);
            resp.setStatus(400);
        }


    }

}


