package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(HttpSession.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        try {
            HttpSession session = req.getSession();
            if(session.isNew()) {
                resp.sendRedirect("/login.jsp");
            } else {
                logger.info(session.getAttribute("admin") + " " + session.getCreationTime());
                session.removeAttribute("admin");
                resp.sendRedirect("/logout.html");
            }
        } catch (Exception e) {
            System.out.println("Exception during logout: " + Arrays.toString(e.getStackTrace()));
        }

    }
}
