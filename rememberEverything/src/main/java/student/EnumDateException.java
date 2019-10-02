package Exception;

public enum EnumDateException {
    WRONG_DAY ("Данного дня не существует"), WRONG_MONTH ("Данного месяца не существует"), WRONG_YEAR ("Данного года не существует");
    private String message;
    EnumDateException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
