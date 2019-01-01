import java.util.*;
//package poker

public class Hand {
    private Card[] hole;
    public ArrayList<Card> allCards;
    /*public enum hands {
        sf,
        q,
        fh,
        f,
        s,
        tp,
        p,
        h;
    }
    [aaaakkkkqqqqjjjjtttt...2222aaaa]

    hand evaluator

    convert hand data into 4 bool sequences by suit, ace to ace
        c=[akqjt...2a],  d=[],    h=[],    s=[]

    straight flush mask: sf = [11111]

    direct searches:
    straight flush: sf<<x & [c|d|h|s], x:0-9
    straight: sf<<x & (c|d|h|s), x:0-9
    flush: sf < [c|d|h|s]
    quads: c&d&h&s
    trips: c&d&h | c&d&s | c&h&s | d&h&s
    pairs: c&d | c&h | c&h | d&h | d&s | h&s

    for full house & two pair:
        -form sets of trips and pairs
        -two pair = top two pairs (if they exist)
        -remove rank of top triple from pairs
        -full house = top triple and top pair (if they exist)





    represent 5 card hand as 52 bits, left justified in groups of 4:
    hand = [aaaa][kkkk][qqqq][jjjj][tttt]...[2222]
        ex:[1111][0001][0000][0000][0000]...[0000]

    categorize with hand % 15:
    high card: [1][1][1][1][1][0]...    = 1+1+1+1+1 = 5
    pair: [11][1][1][1][0]...           = 3+1+1+1   = 6
    two pair: [11][11][1][0]...         = 3+3+1     = 7
    trips: [111][1][1][0]...            = 7+1+1     = 9
    full house: [111][11][0]...         = 7+3       = 10
    quads: [1111][1][0]...              = 15+1      = 1

    7 card hands:
    high card: [1][1][1][1][1][1][1][0]...  = 7
    pair: [11][1][1][1][1][1][0]...         = 8
    two pair: [11][11][1][1][1][0]...       = 9
              [11][11][11][1][0]...         = 10
    trips:  [111][1][1][1][1][0]...         = 11
    full house: [111][11][1][1][0]...       = 12
                [111][11][11][0]...         = 13
                [111][111][1][0]...         = 0
    quads: [1111][1][1][1][0]...            = 3
           [1111][11][1][0]...              = 4
           [1111][111][0]...                = 7 | 22




    straights and flushes



    f:
    */
    public Card[] hand(Card[] community, Card[] holes) {
        //comCards = community;
        hole = holes;
        allCards.add(hole[0]);
        allCards.add(hole[1]);

        //if()
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

/*
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
    hand ranking
    enum? then {sf,q,fh,f,s,tp,p,h}
    enum.values().getIndex()?
    ...
    otherwise idk...
    */


}
