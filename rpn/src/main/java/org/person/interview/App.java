package org.person.interview;
import org.person.interview.calculator.Controller;
import org.person.interview.calculator.ServiceLocator;

public class App
{
    public static void main( String[] args )
    {
        Controller controller = (Controller) ServiceLocator.getApplicationContext().getBean("controller");
        controller.start();
    }
}
