package filter;

import jakarta.inject.Inject;
import jakarta.persistence.PostPersist;
import jakarta.servlet.http.HttpSession;
import model.ActionEntity;
import model.TrainerEntity;

public class PersistTrainerEntityListener {

    @PostPersist
    public void notifyAdminNewTrainer(Object newTrainerEntity) {

        ActionEntity actionEntity = new ActionEntity();
    }

}
