package rest;

import dao.TrainerDao;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.TrainerEntity;

import java.io.Serializable;
import java.util.List;

@Path("/trainers")
public class TrainerResource implements Serializable {

    @Inject
    private TrainerDao trainerDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
        public Response getAllTrainers() {
        List<TrainerEntity> trainers = trainerDao.findAll();
        GenericEntity<List<TrainerEntity>> wrappedTrainers = new GenericEntity<List<TrainerEntity>>(trainers) {
        };
        return Response.ok(wrappedTrainers).build();
    }

    @GET
    @Path("{trainerId:[0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
        public Response getTrainerById(final @PathParam("trainerId") String trainerId) {
        TrainerEntity trainerById = trainerDao.findById(Integer.parseInt(trainerId));
        return Response.ok(trainerById).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
        public Response addTrainer(final TrainerEntity trainerEntity) {
        TrainerEntity newTrainerEntity = trainerDao.save(trainerEntity);
        return Response.ok(newTrainerEntity).build();
    }

    @DELETE
    @Path("{trainerId:[0-9]+}")
        public Response deleteTrainer(final @PathParam("trainerId") String trainerId) {
        trainerDao.delete(Integer.parseInt(trainerId));
        return Response.ok().build();
    }

}
