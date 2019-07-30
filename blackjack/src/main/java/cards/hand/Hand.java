package cards.hand;

import cards.deck.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hand {

    private static final String COMMA_SEPARATOR = ", ";

    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public int getHandValue(){
        int totalValue = cards.stream()
                .mapToInt(Card::getGameValue)
                .sum();

        if(totalValue > 21){
            totalValue = acesLowScore(cards);
        }

        return totalValue;
    }

    private int acesLowScore(List<Card> hand) {
        return hand
                .stream()
                .mapToInt(card -> card.isAce() ? 1 : card.getGameValue())
                .sum();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public String getCardPrettyNames(){
        List<String> prettyNames = cards.stream().map(Card::prettyName).collect(Collectors.toList());
        return String.join(COMMA_SEPARATOR, prettyNames);
    }
}
