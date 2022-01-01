/**
 * Number Guess Module and Response Module
 * @author: Nikhil Hegde
 */

import java.util.Random;

// Response Wrapper
class Result{

    public  boolean status;
    public  String response;

    Result(boolean status, String response){
        this.status = status;
        this.response = response;
    }
}

/**
 * Number Guess Module
 */
public class NumberGuess {

    private int number;

    // Initilize the number
    public NumberGuess(){
        var rm =new  Random();
        number = rm.nextInt(100);
    }

    // test the number passed
    public Result testNumber(int number){
        
        if (number > this.number){
            return new Result(false, String.format("No!!! %d is greater than X", number));
        }
        else if(number < this.number){
            return new Result(false, String.format("No!!! %d is lesser than X", number));
        }
        else{
            return new Result(true, String.format("HOORRAY!!! %d is correct", number));
        }
        
    }
}
