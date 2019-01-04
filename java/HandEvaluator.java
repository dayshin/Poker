//package poker
import java.util.*;

public class HandEvaluator {
    private static final int[] results = {7,8,4,5,0,1,2,-1,3,6};
    private static final String[] names = {"quads","straight flush","straight","flush","high card","pair","two pair","gote","trips","full house"};

    private HandEvaluator() {}

    //finds highest 5 card combo given 5-7 cards
    public static final void evaluate(Card[] cards) {
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

        for(Card c : cards) {
            System.out.print(c.info() + " ");
        }
        System.out.println(" " + id + " " + names[(int)id]);
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
        for(int i=0;i<7;i++){
            for(int j=i;j<7;j++){
                if(i == j) {continue;}
                System.out.println("first excluded is " + i);
                System.out.println("second excluded is " + j);

                int index = 0;
                for(int k=0;k<7;k++){
                    if(k == i || k == j){ continue;}
                    //System.out.println(index);
                    mutableCards[index] = cards[k];
                    index++;

                }
            evaluate(mutableCards);
            }
        }
    }
}
