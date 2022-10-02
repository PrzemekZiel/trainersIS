package service;

import dao.AdminDao;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import model.AdminEntity;

@RequestScoped
public class AdminService {

    @Inject
    private AdminDao adminDao;

    public AdminEntity findAdminByEmail(String email) {
        return adminDao.findAdminByEmail(email);

}

}
