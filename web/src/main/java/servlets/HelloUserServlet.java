package servlets;

import by.itacademy.dto.UserDto;
import by.itacademy.service.UserSecvice;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by цифра on 27.05.2017.
 */
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
        UserDto user = new UserSecvice().getUser(requestedId);
        req.setAttribute("user", user);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/pages/HelloUser.jsp");
        dispatcher.forward(req,resp);
    }
}
