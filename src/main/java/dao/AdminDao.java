package dao;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import model.AdminEntity;

@RequestScoped
public class AdminDao implements AdminDaoInterface<AdminEntity> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AdminEntity findAdminByEmail(String email) {
        Query findAdminByEmail = entityManager.createQuery("SELECT a FROM AdminEntity a WHERE a.email like :emailToFind ");
        findAdminByEmail.setParameter("emailToFind", email);
        return (AdminEntity) findAdminByEmail.getSingleResult();
    }
}
