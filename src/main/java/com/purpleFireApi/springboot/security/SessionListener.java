package com.purpleFireApi.springboot.security;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println(" ====== session created");
        event.getSession().setMaxInactiveInterval(15);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
       System.out.println("====== session destroyed");
    }
}