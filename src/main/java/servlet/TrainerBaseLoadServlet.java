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

@WebServlet("/base")
public class TrainerBaseLoadServlet extends HttpServlet {

    @Inject
    TrainerService trainerService;

    @Inject
    ActionDao actionDao;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("trainers",trainerService.findAllTrainers());
        actionDao.save(createAction(req.getSession(true).getAttribute("adminEmail").toString(), req.getSession(true).getAttribute("userIP").toString(), ActionType.BASE_PREVIEW, "NA - base preview", LocalDateTime.now()));
        if(trainerService.findAllTrainers().isEmpty()) {
            resp.sendRedirect("empty-base.html");
        }
        RequestDispatcher rd = req.getRequestDispatcher("base.jsp");
        rd.forward(req, resp);
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
