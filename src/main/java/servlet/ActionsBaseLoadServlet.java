package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ActionService;
import java.io.IOException;

@WebServlet("/actions")
public class ActionsBaseLoadServlet extends HttpServlet {

    @Inject
    ActionService actionService;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        req.setAttribute("actions", actionService.findAllActions());
        RequestDispatcher rd = req.getRequestDispatcher("actions.jsp");
        rd.forward(req, resp);
    }
}

//TODO pagination in view
//TODO deactivate edit button in case of actions not applicable to trainer or to removed one