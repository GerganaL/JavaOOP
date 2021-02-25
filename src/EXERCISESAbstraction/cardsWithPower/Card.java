package EXERCISESAbstraction.cardsWithPower;



public class Card {
    private CardRank rank;
    private CardSuit suit;
    private int power;

    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
        calculatePower();
    }

    public void calculatePower() {
      this.power = rank.getPower() + suit.getPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", this.rank, this.suit.name(),this.power);
    }
}
