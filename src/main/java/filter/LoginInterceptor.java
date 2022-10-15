package filter;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;
import jakarta.servlet.http.HttpSession;
import model.AdminEntity;
import servlet.LoginServlet;

import java.util.Arrays;
import java.util.logging.Logger;

public class LoginInterceptor {

    Logger logger = Logger.getLogger(LoginInterceptor.class.getName());


    @AroundInvoke
    public Object interceptLogin(InvocationContext invocationContext) throws Exception {

        logger.info("To interceptor");
        Object[] objects = invocationContext.getParameters();
        logger.info(Arrays.toString(objects));
        return invocationContext.proceed();
    }

}
