package servlet;

import dao.ActionDao;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ActionService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@WebServlet("/info")
public class InfoServlet extends HttpServlet {

    @Inject
    ActionDao actionDao;

    @Inject
    ActionService actionService;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        req.setAttribute("statistics", actionDao.groupActions());
        req.setAttribute("actions", actionService.findAllActions());
        RequestDispatcher rd = req.getRequestDispatcher("/stats.jsp");
        rd.forward(req, resp);
    }
}

//TODO statistics:
