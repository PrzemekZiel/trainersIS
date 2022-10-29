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

@WebServlet("/actions")
public class ActionsBaseLoadServlet extends HttpServlet {

    @Inject
    ActionService actionService;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        req.setAttribute("actions", actionService.findAllActions());

        //PrintWriter pw = resp.getWriter();
        //pw.println(actionDao.groupActions());
        //pw.println(actionService.findAllActions());
        RequestDispatcher rd = req.getRequestDispatcher("actions.jsp");
        rd.forward(req, resp);
    }
}
