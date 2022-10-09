package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.FileWriter;
import java.io.IOException;

@WebFilter("/*")
public class FilterAction implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        System.out.println(req.getAttribute("admin") + " " + req.getRemoteAddr() + req.getServletContext().getContextPath());
        filterChain.doFilter(req, resp);
    }
}
