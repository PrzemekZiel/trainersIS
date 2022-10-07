package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.TrainerService;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteTrainerServlet extends HttpServlet {

    @Inject
    TrainerService trainerService;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int trainerId = Integer.parseInt(req.getParameter("trainerId"));
        trainerService.delete(trainerId);
        resp.sendRedirect("/trainer-deleted.html");
    }
}
