package high_card;

public class Runner{

  public static void main(String[] args) {
    Game game = new Game();
    Deck deck = new Deck();
    Player player1 = new Player();
    Player player2 = new Player();
    Console console = new Console();

    player1.takeCard(deck);
    console.display("Player One has the " + player1.showCardsHeld() + ".");
    player2.takeCard(deck);
    console.display("Player Two has the " + player2.showCardsHeld() + ".");
    String result = game.decide(player1.getCardsTotalValue(), player2.getCardsTotalValue());
    console.display(result);
  }
}