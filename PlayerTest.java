import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;


public class PlayerTest {
  
  Dealer dealer;
  Player player;
  Deck deck;

  @Before
  public void before(){
    dealer = new Dealer();
    player = new Player();
    deck = new Deck();
  }

  @Test
  public void takesCardFromDealer(){
    dealer.takeCard(deck);
    player.takeCard(dealer);
    assertEquals(1, player.hand.size());
    // assertEquals("squeak", player.takeCard(dealer));
  }


}