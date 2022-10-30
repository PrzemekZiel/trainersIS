package rest;

import dao.ActionDao;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.ActionEntity;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Path("/actions")
public class ActionResource implements Serializable {

    @Inject
    ActionDao actionDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
        public Response getAllActions() {
        List<ActionEntity> actions = actionDao.findAllActions();
        GenericEntity<List<ActionEntity>> actionWrapper = new GenericEntity<>(actions) {
        };
        return Response.ok(actionWrapper).build();
    }

    @GET
    @Path("{numberOfLast:[0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
        public Response getLastActions(final @PathParam("numberOfLast") String numberofLast) {
        List<ActionEntity> actions = actionDao.findAllActions().stream().skip(actionDao.findAllActions().size() - Integer.parseInt(numberofLast)).collect(Collectors.toList());
        GenericEntity<List<ActionEntity>> actionWrapper = new GenericEntity<>(actions) {
        };
        return Response.ok(actionWrapper).build();
    }

}