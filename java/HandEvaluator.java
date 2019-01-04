//package poker
import java.util.*;

public class HandEvaluator {
    private static final int[] results = {7,8,4,5,0,1,2,3,6};
    private static final String[] names = {"quads","straight flush","straight","flush","high card","pair","two pair", "placeholder", "trips","full house"};
    public static final int[] evaluator = {160, 140, 80, 100, 0, 20, 40,-100, 60, 120 };

    private HandEvaluator() {}


    public static final int evaluate(Card[] cards){
        long id = getId(cards);
        //System.out.println(id);
        int handRating = evaluator[(int)id];
        handRating += rankOfTopFrequency(cards) + 2;
        //System.out.println(handRating);

        return handRating;
    }


    public static final long getId(Card[] cards) {
        /*

            step 1: sort by rules {frequency, rank}
            step 2: categorize first 5 cards
                switch:
                    7 cards:    if type is Q,FH - return type
                                else continue
                    6 cards:    if type is Q,FH,T,TP - return type
                                else continue
                    5 cards:    return type
            step 3: categorize other combinations
                switch:
                    7 cards:    possibilities - trips,twopair,pair,highcard
                                alt check for straight: ?
                                alt check for flush: counting suits?
                    6 cards:    possibilities - pair,highcard


        */

        // hand has hole cards, a number, a top combination, and id
        // in table you can do handeval.top

        //step 1, %15 categorize
        long id = 0;

        int[] counts = new int[13];
        for(Card c : cards) {
            if((++counts[c.rank]) > 0) {
                id |= (1L<<(c.rank*4))*((1L<<counts[c.rank])-1);
            }
        }

        id = id % 15 - 1;

        //step 2, check for straight and/or flush
        if(id == 4) {
            if(straight(cards)) { id-=2; }
            if(flush(cards)) { id-=1; }
        }
        return id;
        //System.out.println(" " + id + " " + names[(int)id] + " " + evaluator[(int)id]);
        //printHand(id);
        //return evaluator[(int)id] + topRank(cards);
    }

    public static int rankOfTopFrequency(Card[] cards){
        int[] counts = new int[13];
        //  2 2 3 4 5 6 7 8 9 T J Q K A
        for(Card c : cards) {
            counts[c.rank]++;
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

    public static void printCards(Card[] cards){
        for(Card c : cards) {
            System.out.print(c.info() + " ");
        }
    }
    public static void printHand(long id){
        System.out.println(names[(int)id]);
    }
    public static int topRank(Card[] cards){
        int rank = cards[0].rank;
        for(Card c : cards){
            if( c.rank > rank ){ rank = c.rank; }
        }
        return rank;
    }
    //checks for straight in first 5 cards of cards array
    public static boolean straight(Card[] cards) {
        long straight = 1<<cards[0].rank|1<<cards[1].rank|1<<cards[2].rank|1<<cards[3].rank|1<<cards[4].rank;
        return straight/(straight&-straight) == 31 || straight == 0b1000000001111;
    }

    //checks for flush in first 5 cards of cards array
    public static boolean flush(Card[] cards) {
        return cards[0].suit == cards[1].suit && cards[1].suit == cards[2].suit && cards[2].suit == cards[3].suit && cards[3].suit == cards[4].suit;
    }

    public static void sevenCardEvaluate(Card[] cards){
        Card[] mutableCards = new Card[5];
        Card[] topFive = new Card[5];
        int topNum = -1;
        for(int i=0;i<7;i++){
            for(int j=i;j<7;j++){
                if(i == j) {continue;}
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
    }
}
