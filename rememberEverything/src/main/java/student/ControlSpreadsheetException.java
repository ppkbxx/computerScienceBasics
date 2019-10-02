package Exception;

import EnumControlSheetException;

public class ControlSpreadsheetException extends Exception {
    private EnumControlSheetException error;
    public ControlSpreadsheetException(EnumControlSheetException error) {
                this.error = error;
            }

            @Override
            public String getMessage() {
                return error.toString();
            }

            public ControlSpreadsheetException(String message) {
                super(message);
            }

            public ControlSpreadsheetException(String message, Throwable cause) {
                super(message, cause);
            }

            public ControlSpreadsheetException(Throwable cause) {
                super(cause);
            }

}
