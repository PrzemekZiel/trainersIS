package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import servlet.LoginServlet;
import servlet.TrainerBaseLoadServlet;

import java.io.IOException;
import java.util.logging.Logger;

@WebFilter("/base")
public class FilterAction implements Filter {

    Logger logger = Logger.getLogger(TrainerBaseLoadServlet.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        String userIP = String.valueOf(session.getAttribute("userIP"));
        String action = req.getServletContext().getServletContextName();
        logger.info(userIP);
        logger.info(action);
        filterChain.doFilter(req, resp);
    }

}