package at.sw2017.calculator;

/**
 * Created by ystc on 16.03.2017.
 */

public class Calculations {
    private Calculations(){

    }

    static int doAdd(int first_number, int second_number){
        return first_number + second_number;
    }

    static int doSub(int first_number, int second_number){
        return first_number - second_number;
    }

    static int doMult(int first_number, int second_number){
        return first_number * second_number;
    }

    static int doDiv(int first_number, int second_number){
        if(second_number == 0){
            return 0;
        }
        return first_number/second_number;
    }
}
