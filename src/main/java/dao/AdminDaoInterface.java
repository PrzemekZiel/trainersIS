package dao;

import java.util.List;

public interface AdminDaoInterface<A> {
    A findAdminByEmail(String email);

    List<A> findAllAdmins();
}
