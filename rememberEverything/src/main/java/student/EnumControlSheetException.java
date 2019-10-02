package student;

public enum EnumControlSheetException {
    WRONG_GROUP("Данной группы не существует"), NO_SUCH_STUDENT("Данного студента не существует"), CONTROL_SHEET_EXCEPTION("Данной ведомости не существует");

    private String message;
    EnumControlSheetException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}