import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.AssertTrue;
import model.TrainerEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TrainerCRUDTests {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

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
        TrainerEntity trainerEntity = new TrainerEntity("michal", "probierz", "cracovia.pl", "+123");
        Set<ConstraintViolation<TrainerEntity>> trainerViolations = validator.validate(trainerEntity);
        assertNotEquals(0, trainerViolations.size());
    }

}
