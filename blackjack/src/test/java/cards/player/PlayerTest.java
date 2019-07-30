package cards.player;

import cards.deck.Card;
import cards.deck.Deck;
import cards.deck.FaceValue;
import cards.hand.Hand;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static cards.deck.FaceValue.*;
import static cards.deck.Suit.*;
import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class PlayerTest {

  private static final Card aceOfSpades = new Card(SPADES, ACE);
  private static final Card jackOfClubs = new Card(CLUBS, JACK);
  private static final Card tenOfDiamonds = new Card(DIAMONDS, TEN);
  private static final Card fiveOfHearts = new Card(HEARTS, FaceValue.FIVE);

  @Mock
  private Deck deck;

  private Player player;

  @Before
  public void before(){
    player = new Player("Player", new Hand());
    initMocks(this);
  }

  @Test
  public void canGetCardsTotal(){
    player.addCardToHand(aceOfSpades);
    player.addCardToHand(fiveOfHearts);

    assertEquals(16, player.getHandValue());
  }


  @Test
  public void handOver21ReportsLoss(){
    player.addCardToHand(fiveOfHearts);
    player.addCardToHand(jackOfClubs);
    player.addCardToHand(tenOfDiamonds);
    assertTrue(player.isBust());
  }

  @Test
  public void handOf21ReportsWin(){
    player.addCardToHand(aceOfSpades);
    player.addCardToHand(jackOfClubs);
    assertTrue(player.hasTwentyOne());
  }

  @Test
  public void canEvaluateHandLessThan21(){
    player.addCardToHand(jackOfClubs);
    assertFalse(player.isBust());
  }

  @Test
  public void handlesAcesLowScenario()  {
    player.addCardToHand(new Card(HEARTS, KING));
    player.addCardToHand(new Card(HEARTS, QUEEN));
    player.addCardToHand(new Card(HEARTS, ACE));
    assertTrue(player.hasTwentyOne());
  }

  @Test
  public void getStatusForOneCard(){
    player.addCardToHand(new Card(HEARTS, KING));
    String expected = "Cards Held: King of Hearts; Total Score: 10";
    String actual = player.getStatus();
    assertNotNull(expected, actual);
  }
  @Test
  public void getStatusString() {
    player.addCardToHand(new Card(HEARTS, KING));
    player.addCardToHand(new Card(HEARTS, QUEEN));

    String expected = "Cards Held: King of Hearts, Queen of Hearts; Total Score: 20";
    assertEquals(expected, player.getStatus());
  }
}