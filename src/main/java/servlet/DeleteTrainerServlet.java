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
import service.TrainerService;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/delete")
public class DeleteTrainerServlet extends HttpServlet {

    @Inject
    TrainerService trainerService;
    @Inject
    ActionDao actionDao;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int trainerId = Integer.parseInt(req.getParameter("trainerId"));
        trainerService.delete(trainerId);
        actionDao.save(createAction(req.getSession(true).getAttribute("adminEmail").toString(), req.getSession(true).getAttribute("userIP").toString(), ActionType.REMOVE, String.valueOf(trainerId), LocalDateTime.now()));
        resp.sendRedirect("/trainer-deleted.html");
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

//TODO confirming deleting