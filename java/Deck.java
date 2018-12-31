//package poker

public class Deck {

    protected final Card[] deck;
    private Card[] card;
    private int size;
    private int next;

    public Deck() {
        this(1);
    }
    public Deck(int s) {
        this.size = s;
        this.card = new Card[size()];
        deck = new Card[size()];
        for(int i = 0; i < size(); i++) {
            deck[i] = new Card((i%52)%13,(i%52)/13);
        }
        reset();
    }

    public String info() {
        String cards = "";
        for(Card c : card) {
            cards += c.info() + " ";
        }
        return cards;
    }
    public void print() {
        System.out.println(this.info());
    }

    public int size() {
        return size * 52;
    }
    public void shuffle() {
        for (int i = 0; i < size(); i++) {
            int c = (int) (Math.random() * (i + 1));
            Card swap = card[c];
            card[c] = card[i];
            card[i] = swap;
        }
    }
    public void reset() {
        next = 0;
        for(int i = 0; i < size(); i++) {
            card[i] = deck[i];
        }
    }
    public Card deal() {
        if(next >= size()) {
            System.out.println("end of deck");
            reset();
            return null;
        }
        card[next].print();
        return card[next++];
    }

}
