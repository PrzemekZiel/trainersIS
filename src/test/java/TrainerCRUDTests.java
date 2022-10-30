import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import model.TrainerEntity;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("CRUD TEST")
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
    @DisplayName("Not only digits in phone number")
    public void letterInPhoneNumber() {
        TrainerEntity trainerEntity = new TrainerEntity("michal", "probierz", "cracovia@pl", "124567i89");
        Set<ConstraintViolation<TrainerEntity>> trainerViolations = validator.validate(trainerEntity);
        assertEquals(1, trainerViolations.size());
    }


}
