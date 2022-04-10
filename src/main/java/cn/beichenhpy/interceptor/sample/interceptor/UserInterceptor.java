package cn.beichenhpy.interceptor.sample.interceptor;

import cn.beichenhpy.interceptor.sample.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <PRE>
 *
 * </PRE>
 * CREATE_TIME: 2022/4/10 14:06
 *
 * @author beichenhpy
 * @version 1.0.0
 */
@Component
@Slf4j
public class UserInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //前置 设置UserContext
        log.info("User interceptor preHandle");
        User admin = new User("admin");
        UserContextHolder.setUserContext(admin);
        log.info("user:{}", UserContextHolder.getUserContext());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //后置 收到抛出异常影响
        log.info("User interceptor postHandle");
        log.info("user:{}", UserContextHolder.getUserContext());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //dispatchServlet后执行的，不受controllerAdvice影响，所以移除ThreadLocal需要在这里做
        log.info("User interceptor afterCompletion");
        UserContextHolder.clear();
        log.info("user:{}", UserContextHolder.getUserContext());
    }
}
