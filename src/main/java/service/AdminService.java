package service;

import dao.AdminDao;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import model.AdminEntity;

import java.util.List;

@RequestScoped
public class AdminService {

    @Inject
    private AdminDao adminDao;

    public AdminEntity findAdminByEmail(String email) {
        return adminDao.findAdminByEmail(email);

}

public List<AdminEntity> findAllAdmins() {
        return adminDao.findAllAdmins();

}

    public boolean isAdmin(String email) {
        return adminDao.findAdminByEmail(email) != null;
    }
}
