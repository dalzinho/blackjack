package cards.game.blackjack;

public enum ResultType {
    P1_WIN("Player One wins!"),
    P2_WIN("Player Two wins!"),
    BUST_DRAW("You are both BUST!"),
    SCORE_DRAW("It's a draw!"),
    PLAYER_HAS_21("You have scored 21!"),
    PLAYER_BUST("You are BUST!");

    private String message;

    ResultType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
