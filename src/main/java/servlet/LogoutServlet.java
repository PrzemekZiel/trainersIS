package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        try {
            HttpSession session = req.getSession();
            if(session.isNew()) {
                resp.sendRedirect("/login.html");
            } else {
                session.removeAttribute("admin");
                System.out.println("log off");
            }
        } catch (Exception e) {
            System.out.println("Exception during logout: " + Arrays.toString(e.getStackTrace()));
        }

    }
}
