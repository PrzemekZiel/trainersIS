package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dto.TrainerDto;
import service.TrainerService;

import java.io.IOException;

@WebServlet("/add-trainer")
public class AddTrainerServlet extends HttpServlet {

    @Inject
    TrainerService trainerService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd = req.getRequestDispatcher("/add-trainer.jsp");
        rd.forward(req, resp);

    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        trainerService.save(createDtoTrainer(name, surname, email, phone));
        resp.sendRedirect("/new-trainer-added.html");

    }

    public TrainerDto createDtoTrainer(String name, String surname, String email, String phone) {
        TrainerDto trainerDto = new TrainerDto();
        trainerDto.setName(name);
        trainerDto.setSurname(surname);
        trainerDto.setEmail(email);
        trainerDto.setPhone(phone);

        return trainerDto;

    }

}
