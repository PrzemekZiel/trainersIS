package dao;

public interface AdminDaoInterface<A> {
    A findAdminByEmail(String email);
}
