package dao;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import model.TrainerEntity;

import java.util.List;

@RequestScoped
public class TrainerDao implements TrainerDaoInterface<TrainerEntity> {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public TrainerEntity save(TrainerEntity trainerEntity) {
        entityManager.persist(trainerEntity);
        return trainerEntity;
    }

    @Transactional
    public void update(TrainerEntity trainerEntity) {
        TrainerEntity trainerEntity1 = findById(trainerEntity.getTrainerId());
        trainerEntity1.setName(trainerEntity.getName());
        trainerEntity1.setSurname(trainerEntity.getSurname());
        trainerEntity1.setEmail(trainerEntity.getEmail());
        trainerEntity1.setPhone(trainerEntity.getPhone());
        entityManager.flush();
    }

    @Transactional
    public void delete(int trainerId) {
        entityManager.remove(findById(trainerId));
    }

    @Override
    public TrainerEntity findById(int id) {
        return entityManager.find(TrainerEntity.class, id);
    }

    @Override
    public List<TrainerEntity> findAll() {
        Query allTrainers = entityManager.createQuery("SELECT t FROM TrainerEntity t");
        return (List<TrainerEntity>) allTrainers.getResultList();
    }

    @Override
    public List<TrainerEntity> findByText(String textToFind) {
        Query findByText = entityManager.createQuery("SELECT t FROM TrainerEntity t WHERE (t.name LIKE :textToFind " +
                "OR t.surname LIKE :textToFind OR t.email LIKE :textToFind OR t.phone LIKE :textToFind)", TrainerEntity.class);
        findByText.setParameter("textToFind", "%" + textToFind + "%");
        return (List<TrainerEntity>) findByText.getResultList();
    }

    @Override
    public List<TrainerEntity> findByEmail(String emailToFind) {
        Query findByEmail = entityManager.createQuery("SELECT t FROM TrainerEntity t WHERE t.email LIKE :emailToFind", TrainerEntity.class);
        findByEmail.setParameter("emailToFind" , emailToFind);
        return (List<TrainerEntity>) findByEmail.getResultList();
    }

    public TrainerEntity findByEmailId(String emailToFindId) {
        return entityManager.find(TrainerEntity.class, emailToFindId);
    }

}

//TODO generify lists