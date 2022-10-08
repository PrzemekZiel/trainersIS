package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.TrainerService;

import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    @Inject
    TrainerService trainerService;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String textToFind = req.getParameter("textToFind");
        req.setAttribute("textToFind", trainerService.findByText(textToFind));
        List searchResults = (List) req.getAttribute("textToFind");
        req.setAttribute("textToFind", searchResults);
        System.out.println(searchResults);
        RequestDispatcher rd = req.getRequestDispatcher("/search.jsp");
        rd.forward(req, resp);

    }
}
