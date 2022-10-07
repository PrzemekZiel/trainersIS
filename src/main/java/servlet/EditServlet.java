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

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    @Inject
    TrainerService trainerService;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        int trainerId = Integer.parseInt(req.getParameter("trainerId"));
        req.setAttribute("trainerToEdit", trainerService.findById(trainerId));
        RequestDispatcher rd = req.getRequestDispatcher("/edit-trainer.jsp");
        rd.forward(req, resp);
    }
}
