package servlet;

import dao.ActionDao;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.ActionEntity;
import model.ActionType;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Inject
    ActionDao actionDao;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        try {
            HttpSession session = req.getSession();
            if(session.isNew()) {
                resp.sendRedirect("/login.jsp");
            } else {
                actionDao.save(createAction(req.getSession(true).getAttribute("adminEmail").toString(), req.getSession(true).getAttribute("userIP").toString(), ActionType.LOGOUT, "NA - LOGOUT", LocalDateTime.now()));
                session.removeAttribute("admin");
                resp.sendRedirect("/logout.html");
            }
        } catch (Exception e) {
            System.out.println("Exception during logout: " + Arrays.toString(e.getStackTrace()));
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
