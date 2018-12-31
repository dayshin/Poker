//package poker
//import java.util.ArrayList;

public class Deck {
    //private String type;
    //private ArrayList<Card> cards;
    private static Card[] deck;
    private Card[] card;
    private int size;
    private int next;

    public Deck() {
        size = 52;
        card = new Card[size];
        deck = new Card[size];
        for(int i = 0; i < size; i++) {
            deck[i] = new Card(i%13,i/13);
        }
        reset();
    }

    public void shuffle() {
        for (int i = 0; i < size; i++) {
            int c = (int) (Math.random() * (i + 1));
            Card swap = card[c];
            card[c] = card[i];
            card[i] = swap;
        }
    }

    public void print() {
        for(Card c : card) {
            c.print();
        }
        System.out.println();
    }

    public void reset() {
        next = 0;
        for(int i = 0; i < size; i++) {
            card[i] = deck[i];
        }
    }

    public Card deal() {
        if(next >= 52) {
            System.out.println("end of deck");
            return null;
        }
        card[next].print();
        return card[next++];
    }

    public static void main(String[] args) {
        /*Deck d = new Deck();
        d.print();
        d.shuffle();
        d.print();
        d.reset();
        d.print();
        for(int i = 0; i < 5; i++) { d.deal(); }*/
    }
}
