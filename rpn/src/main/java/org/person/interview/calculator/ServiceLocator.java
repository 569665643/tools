package org.person.interview.calculator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class ServiceLocator {
    static ApplicationContext applicationContext;
    static {
        applicationContext = new ClassPathXmlApplicationContext("calculator.xml");
    }
    private ServiceLocator(){

    }

    public static void setApplicationContext(ApplicationContext context){
        applicationContext = context;
    }
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
}
