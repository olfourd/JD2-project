package servlets;

import by.itacademy.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class HelloUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/http;charset=utf-8");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/pages/EnterUserId.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long requestedId = Long.valueOf(req.getParameter("userId"));
//        User user = userService.getById(requestedId);
//        req.setAttribute("user", user);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/pages/HelloUser.jsp");
        dispatcher.forward(req,resp);
    }

}
