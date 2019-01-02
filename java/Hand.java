//package poker

public class Hand {
    public Card[] cards;
    private static final int[] results = {7,8,4,5,0,1,2,-1,3,6};
    private static final String[] names = {"quads","straight flush","straight","flush","high card","pair","two pair","gote","trips","full house"};

    public Hand() {
        this.cards = new Card[5];
        for(int i = 0; i < 5; i++) {
            cards[i] = new Card();
        }
    }

    /*

        hand evaluation

        necessary representations of a hand:

        count = [aaaa][kkkk][qqqq][jjjj][tttt]...[2222]
            ex:[1111][0001][0000][0000][0000]...[0000]
        rank = [akqjt...2a]
            ex:[111110...]
        suit = { [c,d,h,s][][][][]... }
            ex:{[0][0][1][2][3]}

        categorize with hand % 15:

        5 card hands:

        high card: [1][1][1][1][1][0]...                = 1+1+1+1+1 = 5 > 4
        pair: [11][1][1][1][0]...                       = 3+1+1+1   = 6 > 5
        two pair: [11][11][1][0]...                     = 3+3+1     = 7 > 6
        trips: [111][1][1][0]...                        = 7+1+1     = 9 > 8
        full house: [111][11][0]...                     = 7+3       = 10> 9
        quads: [1111][1][0]...                          = 15+1      = 1 > 0
        +
        straight: rank/(rank&-rank) == 31                           = -2> 2
        flush: suits[0] == (suits[1]|suits[2]|suits[3]|suits[4])    = -1> 3,1
        =
        result: quads,straight flush,straight,flush,high card,pair,two pair,X,trips,full house

        hand comparison
        int[] r = ranks after sorting by amount>rank
        int t = hand evaluation

    */

    public void evaluate() {
        // s = [akqjt987654321] ignoring duplicates
        // ex: [2,3,2,K,9] -> [01000100000010]
        long s = 1<<cards[0].rank|1<<cards[1].rank|1<<cards[2].rank|1<<cards[3].rank|1<<cards[4].rank;
        long v = 0;

        int[] counts = new int[13];
        for(Card c : cards) {
            counts[c.rank]++;
        }

        for(int i = 0; i < 13; i++) {
            if(counts[i] > 0) {
                //v = [aaaakkkkqqqqjjjjtttt99998888777766665555444433332222] as described above
                v += (1L<<(i*4))*((1L<<counts[i])-1);
            }
        }

        v = v % 15 - 1;
        if(v == 4) {
            if(s/(s&-s) == 31) { v -= 2; }
            if(cards[0].suit == cards[1].suit && cards[1].suit == cards[2].suit && cards[2].suit == cards[3].suit &&
            cards[3].suit == cards[4].suit) { v--; }
        }
        for(Card c : cards) {
            System.out.print(c.info() + " ");
        }
        System.out.println(" " + v + " " + names[(int)v]);

    }

    public static final Card[] sort(Card[] cards) {
        int max = 0;
        int rank = 0;
        int[] counts = new int[12];
        for(Card c : cards) {
            if(max < ++counts[c.rank]) {
                max = counts[c.rank];
                rank = c.rank;
            }
        }



        int i;
        int[] countf = new int[max];
        for(i = 0; i < counts.length; i++) {
            countf[counts[i]]++;
        }
        for(i = countf.length - 1; i > -1; i--) {
            //for(int j = )
        }
        /*
        for(int i = 0; i < n-1; i++) {
            for(int j = 0; j < n-i-1; j++) {
                if(c[j].compare(c[j+1]) > 0) {
                    Card swap = c[j];
                    c[j] = c[j+1];
                    c[j+1] = swap;
                }
            }
        }*/
        return cards;
    }

}
