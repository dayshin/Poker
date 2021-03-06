//package poker;

public class Card {
    public static final String[] suits = {"c","d","h","s"};
    public static final String[] ranks = {"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
    protected int rank;
    protected int suit;

    public Card() {
        this((int)(Math.random()*13),(int)(Math.random()*4));
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
