import java.util.*;
//package poker

public class Hand {
    private Card[] hole;
    public ArrayList<Card> allCards;
    // if we handle comparisons in hand it has to be global
    /*public enum hands {
        sf,
        q,
        fh,
        f,
        s,
        tp,
        p,
        h
    }*/
    public Card[] hand(Card[] community, Card[] holes) {
        comCards = community;
        hole = holes;
        allCards.add(hole[0])
        allCards.add(hole[1])

        if()
        return null;
    }

    public static Card[] sort(Card[] cards) {
        int n = cards.length;
        for(int i = 0; i < n-1; i++) {
            for(int j = 0; j < n-i-1; j++) {
                if(cards[j].compare(cards[j+1]) > 0) {
                    Card swap = cards[j];
                    cards[j] = cards[j+1];
                    cards[j+1] = swap;
                }
            }
        }
    }

    public int sf(Card[] cards) {
        return false;
    }
    public int q() {
        return false;
    }
    public int fh() {
        return false;
    }
    public int f() {
        return false;
    }
    public int s() {
        return false;
    }


    public int compare(Hand other) {
        return 0;
    }
    // return 0 if no pair
    // return rank of pair if pair exists
    public int hasPair(){
      for(int i=0;i<allCards.length;i++){
        for(int j=0;j<allCards.length;j++){
          if(j == i) continue;
          if( allCards[i].rank == allCards[j].rank){
            return allCards[i].rank;
          }
        }
      }
      return
    }
    public int hasTwoPair(){
      // first discovered pair
      firstPair = hasPair();
      if(firstPair == 0) return 0;
      for(int i=0;i<allCards.length;i++){
        for(int j=0;j<allCards.length;j++){
          if(j == i) continue;
          if( allCards[i].rank == allCards[j].rank){
            if() allCards[i].rank;
          }
        }
      }
    }
    public int hasTrips(){
      for(int i=0;i<allCards.length;i++){
        for(int j=0;j<allCards.length;j++){
          for(int k=0;k<allCards.length;k++){
            if(i == j || j == k) continue;
            rank1 = allCards[i].rank;
            rank2 = allCards[j].rank;
            rank3 = allCards[k].rank;
            if(rank1 == rank2 && rank2 == rank3){
              return allCards[i].rank;
            }
          }
        }
      }
    }
      /* hand ranking
     * enum? then {sf,q,fh,f,s,tp,p,h}
     * enum.values().getIndex()?
     * ...
     *
     * otherwise idk...
     */

     // hasPair()
     // hasFlush()
     // etc should be helpful.

}
