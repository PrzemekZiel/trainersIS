package servlet;

import dao.ActionDao;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ActionEntity;
import model.ActionType;
import model.TrainerEntity;
import service.TrainerService;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/update")
public class UpdateTrainerServlet extends HttpServlet {

    @Inject
    TrainerService trainerService;

    @Inject
    ActionDao actionDao;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Integer trainerId = Integer.parseInt(req.getParameter("trainerId"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        trainerService.update(updateTrainer(trainerId, name, surname, email, phone));
        actionDao.save(createAction(req.getSession(true).getAttribute("adminEmail").toString(), req.getSession(true).getAttribute("userIP").toString(), ActionType.UPDATE, String.valueOf(trainerId), LocalDateTime.now()));

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

    public static ActionEntity createAction (String adminEmail, String userIP, ActionType actionType, String urlLink, LocalDateTime date) {
        ActionEntity actionEntity = new ActionEntity();
        actionEntity.setAdminEmail(adminEmail);
        actionEntity.setUserIP(userIP);
        actionEntity.setActionType(actionType);
        actionEntity.setUrlLink(urlLink);
        actionEntity.setDate(date);

        return actionEntity;
    }

}
