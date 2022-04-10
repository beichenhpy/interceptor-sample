package cn.beichenhpy.interceptor.sample.interceptor;

import cn.beichenhpy.interceptor.sample.entity.User;

/**
 * <PRE>
 *
 * </PRE>
 * CREATE_TIME: 2022/4/10 14:08
 *
 * @author beichenhpy
 * @version 1.0.0
 */
public class UserContextHolder {

    private static final ThreadLocal<User> userContext = new ThreadLocal<>();

    public static void setUserContext(User user){
        userContext.set(user);
    }


    public static User getUserContext(){
       return userContext.get();
    }


    public static void clear(){
        userContext.remove();
    }
}
