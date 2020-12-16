package org.person.interview.calculator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpressionItem{
    private String value;
    private int position;

    public String getValue(){
        return value;
    }
    public int getPosition() { return position;}

    public ExpressionItem(String value, int position){
        this.value = value;
        this.position = position;
    }


}
