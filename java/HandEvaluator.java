//package poker

public class HandEvaluator {
    private static final int[] results = {7,8,4,5,0,1,2,3,6};
    private static final String[] names = {"quads","straight flush","straight","flush","high card","pair","two pair", "gote", "trips","full house"};

    private HandEvaluator() {}

    public static final int evaluate(Card[] cards) {
        int suits = cards[0].suit()&cards[1].suit();
        int ranks;
        return e(suits,0);
    }

    private static final int e(int suits, int ranks) {
        long id = 0;
/*      int max = 0;
        int next = 0;
        int[] sorted = new int[5];

        int[] counts = new int[13];
        for(Card c : cards) {
            if(++counts[c.rank()] > 0) {
                id |= (1L<<(c.rank()*4))*((1L<<counts[c.rank()])-1);
                if(max < counts[c.rank()]) {
                    max = counts[c.rank()];
                }
            }




        // 41 32 311 221 2111 11111
        int p = 0;
        for(int t = 0; t < 2; t++) {
            for(int c = 12; c > -1; c--) {
                if(counts[c] == max) {
                    int j;
                    for(j = 0; j < max; j++) {
                        sorted[p+j] = c;
                    }
                    p += j;
                } else {
                    if( counts[c] > 0 ) next = counts[c];
                }
            }
            max = next;
        }
        */
        id = id % 15 - 1;

        /*if(id == 4) {
            if(straight(cards)) { id-=2; }
            if(flush(cards)) { id-=1; }
        }

        for(int i : sorted) {
            System.out.print(Card.ranks[i] + " ");
        }
        System.out.println();
        */
        return (int)id;
    }

    //checks for straight in first 5 cards of cards array
    public static boolean straight(Card[] cards) {
        long straight = (cards[0].info|cards[1].info|cards[2].info|cards[3].info|cards[4].info) >> 4;
        return straight/(straight&-straight) == 31 || straight == 0b1000000001111;
    }

    //checks for flush in first 5 cards of cards array
    public static boolean flush(Card[] cards) {
        return (cards[0].info&cards[1].info&cards[2].info&cards[3].info&cards[4].info) > 0;
    }

    public static int sevenCardEvaluate(Card[] cards){
        Card[] mutableCards = new Card[5];
        Card[] topFive = new Card[5];
        int topNum = -1;
        for(int i=0;i<7;i++){
            for(int j=i+1;j<7;j++){
                //if(i == j) {continue;} redundant
                // System.out.println("first excluded is " + i);
                // System.out.println("second excluded is " + j);

                int index = 0;
                for(int k=0;k<7;k++){
                    if(k == i || k == j){ continue;}
                    //System.out.println(index);
                    mutableCards[index] = cards[k];
                    index++;
                }
            if( evaluate(mutableCards) >= topNum ){
                System.arraycopy(mutableCards, 0, topFive, 0 , 5);
                topNum = evaluate(mutableCards);
                }
            }
        }

        System.out.println("This is the top combination");
        System.out.println("Hand rank: " + evaluate(topFive));
        printCards(topFive);
        System.out.println();
        System.out.println();
        return topNum;
    }

    public static void compareHands(Card[] hand1, Card[] hand2){
        int value1 = sevenCardEvaluate(hand1);
        int value2 = sevenCardEvaluate(hand2);
        if( value1 > value2){
            System.out.println("Hand 1 wins!");
            //printCards(hand1);
        }
        else if ( value2 > value1){
            System.out.println("Hand 2 wins!");
            //printCards(hand2);
        }
        else {
            System.out.println("Split the pot!");
            //printCards(hand1);
            //printCards(hand2);
        }
    }

    public static void printCards(Card[] cards){
        for(Card c : cards) {
            System.out.print(c.info() + " ");
        }
    }

    public static void printHand(long id){
        System.out.println(names[(int)id]);
    }

    public static int topRank(Card[] cards){
        int rank = cards[0].rank();
        for(Card c : cards){
            if( c.rank() > rank ) { rank = c.rank(); }
        }
        return rank;
    }

    public static int rankOfTopFrequency(Card[] cards){
        int[] counts = new int[13];
        //  2 2 3 4 5 6 7 8 9 T J Q K A
        for(Card c : cards) {
            counts[c.rank()]++;
        }
        int topFrequency = 0;
        for(int i=counts.length-1;i>0;i--){
            if(counts[i] == 3){
                return i;
            }
        }
        for(int i=counts.length-1;i>0;i--){
            if(counts[i] == 2){
                return i;
            }
        }
        return topRank(cards);
    }


}