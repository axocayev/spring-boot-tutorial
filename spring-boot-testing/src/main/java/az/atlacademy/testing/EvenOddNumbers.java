package az.atlacademy.testing;

public class EvenOddNumbers {

    public boolean isEven(int number){
        if(number<0){
            return  false;
        }
        return number%2==0;
    }
}
