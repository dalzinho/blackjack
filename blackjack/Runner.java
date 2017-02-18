public class Runner{

  public static void main(String[] args) {
    Game game = new Game();
    Deck deck = new Deck();
    Player player1 = new Player();
    Player player2 = new Player();
    Console console = new Console();

    player1.takeCard(deck);
    player1.takeCard(deck);
    console.display(player1.showCardsHeld());
  }
}