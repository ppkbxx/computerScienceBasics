package student;

public class DateException extends Exception {
    private EnumDateException error;
    public DateException(EnumDateException error) {
        this.error = error;
    }

    @Override
    public String getMessage() {
        return error.toString();
    }

    public DateException(String message) {
        super(message);
    }

    public DateException(String message, Throwable cause) {
        super(message, cause);
    }

    public DateException(Throwable cause) {
        super(cause);
    }
}
