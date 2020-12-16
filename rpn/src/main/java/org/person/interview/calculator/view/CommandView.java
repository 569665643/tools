package org.person.interview.calculator.view;

import org.apache.commons.lang.StringUtils;
import org.person.interview.calculator.CalculateState;
import org.person.interview.calculator.Controller;
import org.person.interview.calculator.ErrorInfo;
import org.person.interview.calculator.Expression;
import org.person.interview.calculator.config.IConfiguration;
import org.person.interview.calculator.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandView implements IView{

    @Autowired
    private Controller controller;

    @Autowired
    private IConfiguration configuration;

    @Override
    public void show(CalculateState state) {
        if(state.getErrorInfo() != null){
            this.error(state.getErrorInfo());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("stack:");
        state.getOperandStack().stream().forEach(item -> sb.append(String.format("%s ", this.formatDisplayValue(item))));
        System.out.println(sb.toString());
    }

    public void error(ErrorInfo error) {
        System.out.println(String.format("Operator %s (position: %s)： %s", error.getItem().getValue(), error.getItem().getPosition(),error.getMsg()));
    }

    @Override
    public void start() {
        System.out.println("Welcome to RPN calculator!");
        System.out.println("Enter QUIT to exit");

        final String quitString = "QUIT";

        this.show(new CalculateState());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean isQuit = false;
        String inputLine = null;

        do{
            try {
                inputLine = br.readLine();

                Expression expression = null;
                if(!StringUtils.isEmpty(inputLine)){
                    if(inputLine.contains(quitString)){
                        String[] parts = inputLine.split("QUIT");
                        isQuit = true;
                        if(parts.length > 0) {
                            expression = Expression.createFromString(parts[0]);
                        }
                    }else{
                        expression = Expression.createFromString(inputLine);
                    }

                   if(expression != null && expression.getItems().size() > 0) {
                       this.controller.input(expression);
                   }
                }
            }catch(IOException ex){
                System.out.println("Encounter exception:" + ex.getMessage());
                isQuit = true;
            }
        }while(!isQuit);

        this.controller.close();
    }

    private String formatDisplayValue(String value){
        return Utils.formatToPrecision(value, configuration.getPrecision());
    }
}
