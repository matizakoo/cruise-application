package com.zak.cruise.config;

//import com.zak.cruise.service.impl.SingInUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Configuration
public class SessionConfig extends HandlerInterceptorAdapter {
    Logger logger = LoggerFactory.getLogger("Sign up session");
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //get all cookies
        //log session id
        //log the request path

        String sessionId = null;

        if(null != request.getCookies()){
            for(Cookie cookie: request.getCookies()){
                if("JSESSIONID".equals(cookie.getName()))
                    sessionId = cookie.getValue();
            }
        }
        logger.info("Request data log : " + sessionId +
                " at " + new Date() + " for " + request.getRequestURL());

        return true;
    }
}
