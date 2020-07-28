package by.epamtc.jwd.busel.textbook_parser.service.exception;

public class ServiceException extends Exception {
    private static final long serialVersionUID = -705405513818038653L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
