package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TrainerEntity;
import service.TrainerService;

import java.io.IOException;

@WebServlet("/update")
public class UpdateTrainerServlet extends HttpServlet {

    @Inject
    TrainerService trainerService;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Integer trainerId = Integer.parseInt(req.getParameter("trainerId"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        trainerService.update(updateTrainer(trainerId, name, surname, email, phone));
        resp.sendRedirect("/trainer-updated.html");
    }

    public static TrainerEntity updateTrainer(Integer trainerId, String name, String surname, String email, String phone) {
        TrainerEntity trainerEntity = new TrainerEntity();
        trainerEntity.setTrainerId(trainerId);
        trainerEntity.setName(name);
        trainerEntity.setSurname(surname);
        trainerEntity.setEmail(email);
        trainerEntity.setPhone(phone);

        return trainerEntity;
    }
}
