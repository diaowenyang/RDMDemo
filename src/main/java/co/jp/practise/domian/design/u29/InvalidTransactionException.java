package co.jp.practise.domian.design.u29;


public class InvalidTransactionException extends Exception {

    public InvalidTransactionException(String message) {
        super(message);
        System.out.println(message);
    }

}
