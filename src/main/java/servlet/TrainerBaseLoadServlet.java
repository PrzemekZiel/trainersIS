package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.TrainerService;

import java.io.IOException;

@WebServlet("/base")
public class TrainerBaseLoadServlet extends HttpServlet {

    @Inject
    TrainerService trainerService;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getSession().getAttribute("admin"));

        req.setAttribute("trainers",trainerService.findAllTrainers());
        if(trainerService.findAllTrainers().isEmpty()) {
            resp.sendRedirect("empty-base.html");
        }
        RequestDispatcher rd = req.getRequestDispatcher("base.jsp");
        rd.forward(req, resp);
    }
}
