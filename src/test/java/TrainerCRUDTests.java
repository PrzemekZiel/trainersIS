import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Null;
import model.TrainerEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import service.TrainerService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("CRUD TEST")
public class TrainerCRUDTests {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    @Inject
    TrainerService trainerService;

    @Test
    @DisplayName("Trainer added without errors")
        public void newTrainerAllOK() {
        TrainerEntity trainerEntity = new TrainerEntity("michal", "probierz", "cracovia@pl", "+123");
        Set<ConstraintViolation<TrainerEntity>> trainerViolations = validator.validate(trainerEntity);
        assertEquals(0, trainerViolations.size());
    }

    @Test
    @DisplayName("Email error")
        public void wrongTrainerEmailError() {
        Set<ConstraintViolation<TrainerEntity>> trainerViolations = validator.validateValue(TrainerEntity.class, "email", "einvalidEmail");
        assertEquals(1, trainerViolations.size());
    }

    @Test
    @DisplayName("Null errors")
        public void nullTrainerFieldValues() {
        TrainerEntity trainerEntity = new TrainerEntity();
        Set<ConstraintViolation<TrainerEntity>> trainerViolations = validator.validate(trainerEntity);
        assertEquals(4, trainerViolations.size());
    }

@Test
    public void findByNameCheck () {
    TrainerEntity trainerEntity = new TrainerEntity("michal", "probierz", "cracovia@pl", "+123");
    //String testTekst = trainerService.findByEmail("cracovia@pl").ge.toString();
    //assertEquals();
}

}
