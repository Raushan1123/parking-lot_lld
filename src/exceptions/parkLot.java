package exceptions;

public class parkLot extends RuntimeException{
    public parkLot(){

    }
    public parkLot(String msg){
        super(msg);
    }
}
