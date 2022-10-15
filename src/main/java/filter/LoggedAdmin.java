package filter;

import model.AdminEntity;

public class LoggedAdmin extends ThreadLocal<AdminEntity> {
    public static LoggedAdmin INSTANCE = new LoggedAdmin();
    private LoggedAdmin() {
    }
}
