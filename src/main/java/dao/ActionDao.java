package dao;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import model.ActionEntity;

@RequestScoped
public class ActionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public ActionEntity save(ActionEntity actionEntity) {
        entityManager.persist(actionEntity);
        return actionEntity;
    }
}
