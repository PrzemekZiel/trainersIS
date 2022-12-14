package servlet;

import dao.ActionDao;
import filter.LoginInterceptor;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.interceptor.Interceptors;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.ActionEntity;
import model.ActionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.AdminService;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Interceptors(LoginInterceptor.class)
@WebServlet("/login")
@ApplicationScoped
public class LoginServlet extends HttpServlet {


    @Inject
    AdminService adminService;

    @Inject
    ActionDao actionDao;

    private final Logger logger = LoggerFactory.getLogger(HttpSession.class);

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {



        try {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            HttpSession session = req.getSession();
            Map<String, String> loginData = new HashMap<>();
            loginData.put(email, password);

            if (adminService.isAdmin(email)) {
                Map<String, String> loginInDatabase = new HashMap<>();
                loginInDatabase.put(adminService.findAdminByEmail(email).getEmail(), adminService.findAdminByEmail(email).getPassword());

                if (loginData.equals(loginInDatabase)) {
                    session.setAttribute("admin", adminService.findAdminByEmail(email));
                    session.setAttribute("userIP", req.getRemoteAddr());
                    session.setAttribute("adminEmail", adminService.findAdminByEmail(email).getEmail());
                    actionDao.save(createAction(req.getSession(true).getAttribute("adminEmail").toString(), req.getSession(true).getAttribute("userIP").toString(), ActionType.LOGIN, "NA - LOGIN", LocalDateTime.now()));
                    RequestDispatcher rd = req.getRequestDispatcher("/logged.jsp");
                    rd.forward(req, resp);
                    } else {
                    session.setAttribute("wrongPassword", "Wrong password for:" + adminService.findAdminByEmail(email).getEmail());
                    System.out.println(session.getAttribute("wrongPassword"));
                    resp.sendRedirect("login.jsp");
                    }
            }
        } catch (Exception e) {

            resp.sendRedirect("login.jsp");
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

//TODO tests
//TODO exceptions
//TODO interceptor for logging to a text file unsuccessful logging, removing wrong password or no admin