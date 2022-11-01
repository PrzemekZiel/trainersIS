package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/edit", "/base", "/add-trainer", "/delete", "/search", "/logout", "/actions", })
public class FilterLogin implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        try {
        HttpSession session = req.getSession();

        if(session.getAttribute("admin") == null) {
            RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
            rd.forward(req, resp);
            }
        filterChain.doFilter(req, resp);
        } catch (Exception e) {
            RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
            rd.forward(req, resp);
        }
        }

    }

