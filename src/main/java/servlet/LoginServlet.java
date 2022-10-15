package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.AdminService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Inject
    AdminService adminService;

    private final Logger logger = LoggerFactory.getLogger(HttpSession.class);


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {

            HttpSession session = req.getSession();
            Map<String, String> loginData = new HashMap<>();
            loginData.put(email, password);

            if (adminService.isAdmin(email)) {
                Map<String, String> loginInDatabase = new HashMap<>();
                loginInDatabase.put(adminService.findAdminByEmail(email).getEmail(), adminService.findAdminByEmail(email).getPassword());

                if (loginData.equals(loginInDatabase)) {
                    session.setAttribute("admin", adminService.findAdminByEmail(email));
                    logger.info(session.getAttribute("admin") + " " + req.getRemoteAddr());
                    RequestDispatcher rd = req.getRequestDispatcher("/logged.jsp");
                    rd.forward(req, resp);
                    } else {
                    session.setAttribute("wrongPassword", "Wrong password for:" + adminService.findAdminByEmail(email).getEmail());
                    System.out.println(session.getAttribute("wrongPassword"));
                    resp.sendRedirect("login.jsp");
                    }
            } else {
                session.setAttribute("wrongEmail", "Wrong email for:" + email);
                PrintWriter pw = resp.getWriter();
                pw.println(session.getAttribute("wrongEmail")  + "nie admin");
                resp.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            resp.sendRedirect("login.jsp");
        }
    }
}
