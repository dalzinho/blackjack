public class Runner{

  public static void main(String[] args) {
    Game game = new Game();
    Deck deck = new Deck();
    Player player1 = new Player();
    Player player2 = new Player();
    Console console = new Console();

    game.start(player1, player2, deck, console);
  }
}