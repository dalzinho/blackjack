package blackjack.deck;

public class DeckException extends RuntimeException {

    public DeckException() {
    }

    public DeckException(String s) {
        super(s);
    }

    public DeckException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeckException(Throwable cause) {
        super(cause);
    }
}
