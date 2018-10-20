package exception;

public class InvalidRiskMapException extends Throwable{

    String message;

    public InvalidRiskMapException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
