package servlet;

import dao.ActionDao;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ActionEntity;
import model.ActionType;
import service.TrainerService;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    @Inject
    TrainerService trainerService;

    @Inject
    ActionDao actionDao;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        try {
            int trainerId = Integer.parseInt(req.getParameter("trainerId"));
            req.setAttribute("trainerToEdit", trainerService.findById(trainerId));
            actionDao.save(createAction(req.getSession(true).getAttribute("adminEmail").toString(), req.getSession(true).getAttribute("userIP").toString(), ActionType.EDIT, String.valueOf(trainerId), LocalDateTime.now()));
            RequestDispatcher rd = req.getRequestDispatcher("/edit-trainer.jsp");
            rd.forward(req, resp);
        } catch (IllegalArgumentException e) {
            req.setAttribute("errorMessage", "You cannot edit action without id!");
            RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
            rd.forward(req, resp);
        }
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
