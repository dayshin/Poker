//package poker;

public class Card {
    public static final String[] suits = {"♣","♦","♥","♠"};
    public static final String[] ranks = {"2","3","4","5","6","7","8","9","T","J","Q","K","A"};

    protected int rank;
    protected int suit;

    public Card() {
        this(0,0);
    }
    public Card(int r, int s) {
        this.rank = r;
        this.suit = s;
    }

    public String info() {
        return ranks[rank] + suits[suit];
    }
    public void print() {
        System.out.println(this.info());
    }

    public int compare(Card other) {
        return this.rank - other.rank;
    }

}
