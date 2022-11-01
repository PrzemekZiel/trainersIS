package dao;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import model.ActionEntity;
import query.ActionCount;
import java.util.List;

@RequestScoped
public class ActionDao implements ActionDaoInterface<ActionEntity> {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public ActionEntity save(ActionEntity actionEntity) {
        entityManager.persist(actionEntity);
        return actionEntity;
    }
    @Override
    public List<ActionEntity> findAllActions() {
        Query allActions = entityManager.createQuery("SELECT a FROM ActionEntity a");
        return (List) allActions.getResultList();
    }

    public List<ActionCount[]> groupActions() {
        Query groupActions = entityManager.createQuery("SELECT a.actionType, count(a) FROM ActionEntity a GROUP BY a.actionType ORDER BY count(a) DESC");
        return (List<ActionCount[]>) groupActions.getResultList();
    }

}

//TODO generify classes?