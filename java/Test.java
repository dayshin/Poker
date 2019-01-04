public class Test {
    public static void main(String[] args) {
        Card[] cards = new Card[5];

        //straight flush
        for(int i = 0; i < 5; i++) {
            cards[i] = new Card(i,0);
        }
        HandEvaluator.evaluate(cards);

        //full house
        for(int i = 0; i < 5; i++) {
            cards[i] = new Card(i%2,(i+1)%4);
        }
        HandEvaluator.evaluate(cards);

        //flush
        int suit = (int)(Math.random()*4);
        for(int i = 0; i < 5; i++) {
            cards[i] = new Card(i*2,suit);
        }
        HandEvaluator.evaluate(cards);

        //straight
        for(int i = 0; i < 5; i++) {
            cards[i] = new Card(i,(int)(Math.random()*4));
        }
        HandEvaluator.evaluate(cards);

        //trips
        for(int i = 0; i < 5; i++) {
            cards[i] = new Card((i/3)*(int)(Math.random()*10),i%4);
        }
        HandEvaluator.evaluate(cards);

        //two pair
        for(int i = 0; i < 5; i++) {
            cards[i] = new Card(i/2,i%4);
        }
        HandEvaluator.evaluate(cards);

        Card[] sevenCards = new Card[7];
        for(int i = 0; i < 7; i++) {
            sevenCards[i] = new Card();
        }
        HandEvaluator.sevenCardEvaluate(sevenCards);

    }
}
