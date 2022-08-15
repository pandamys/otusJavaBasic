package perminov.otus.homeworks.finalwork;

public class UnsupportedCurrencyException extends RuntimeException {
    private final String message;

    public UnsupportedCurrencyException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "Не поддерживаемая валюта: " + message;
    }
}
