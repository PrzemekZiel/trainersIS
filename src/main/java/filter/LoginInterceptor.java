package filter;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;
import model.AdminEntity;
import servlet.LoginServlet;

import java.util.logging.Logger;

public class LoginInterceptor {

    Logger logger = Logger.getLogger(LoginServlet.class.getName());


    @AroundInvoke
    public Object interceptLogin(InvocationContext invocationContext) throws Exception {
        logger.info("To interceptor");
        return invocationContext.proceed();
    }

}
