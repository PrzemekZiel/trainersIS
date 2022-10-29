package dao;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import model.AdminEntity;

import java.util.List;

@RequestScoped
public class AdminDao implements AdminDaoInterface<AdminEntity> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AdminEntity findAdminByEmail(String emailToFind) {
        Query findAdminByEmail = entityManager.createQuery("SELECT a FROM AdminEntity a WHERE a.email like :emailToFind ", AdminEntity.class);
        findAdminByEmail.setParameter("emailToFind", emailToFind);
        return (AdminEntity) findAdminByEmail.getSingleResult();
    }

    @Override
    public List<AdminEntity> findAllAdmins() {
        Query findAllAdmins = entityManager.createQuery("SELECT a FROM AdminEntity a");
        return (List<AdminEntity>) findAllAdmins.getResultList();

    }

}

//TODO generify list