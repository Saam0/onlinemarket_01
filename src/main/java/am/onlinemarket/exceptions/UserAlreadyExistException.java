package am.onlinemarket.exceptions;

public final class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(final String message) {
        super(message);
    }

}
