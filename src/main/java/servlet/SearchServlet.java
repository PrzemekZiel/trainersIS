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
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    @Inject
    TrainerService trainerService;
    @Inject
    ActionDao actionDao;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String textToFind = req.getParameter("textToFind");
        req.setAttribute("textToFind", trainerService.findByText(textToFind));
        List searchResults = (List) req.getAttribute("textToFind");
        req.setAttribute("textToFind", searchResults);
        actionDao.save(createAction(req.getSession(true).getAttribute("adminEmail").toString(), req.getSession(true).getAttribute("userIP").toString(), ActionType.SEARCH, "Text to find: " +textToFind, LocalDateTime.now()));

        System.out.println(searchResults);
        RequestDispatcher rd = req.getRequestDispatcher("/search.jsp");
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
