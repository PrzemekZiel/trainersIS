package servlet;

import dao.ActionDao;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dto.TrainerDto;
import model.ActionEntity;
import model.ActionType;
import service.TrainerService;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

@WebServlet("/add-trainer")
public class AddTrainerServlet extends HttpServlet {

    @Inject
    TrainerService trainerService;

    @Inject
    ActionDao actionDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd = req.getRequestDispatcher("/add-trainer.jsp");
        rd.forward(req, resp);

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        trainerService.save(createDtoTrainer(name, surname, email, phone));
        actionDao.save(createAction(req.getSession(true).getAttribute("adminEmail").toString(), req.getSession(true).getAttribute("userIP").toString(), ActionType.ADD, trainerService.findByEmail(email).stream().reduce((first, second) -> second).map(TrainerDto::getTrainerId).map(Objects::toString).orElse(null), LocalDateTime.now()));
        resp.sendRedirect("/new-trainer-added.html");

    }

    public TrainerDto createDtoTrainer(String name, String surname, String email, String phone) {
        TrainerDto trainerDto = new TrainerDto();
        trainerDto.setName(name);
        trainerDto.setSurname(surname);
        trainerDto.setEmail(email);
        trainerDto.setPhone(phone);

        return trainerDto;

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
