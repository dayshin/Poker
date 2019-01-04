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


    public void evaluate() {
        long s = 1<<cards[0].rank|1<<cards[1].rank|1<<cards[2].rank|1<<cards[3].rank|1<<cards[4].rank;
        long id = 0;

        int[] counts = new int[13];
        for(Card c : cards) {
            counts[c.rank]++;
        }

        for(int i = 0; i < 13; i++) {
            if(counts[i] > 0) {
                id += (1L<<(i*4))*((1L<<counts[i])-1);
            }
        }

        id = id % 15 - 1;

        if(id == 4) {
            if(s/(s&-s) == 31) { id -= 2; }
            if(cards[0].suit == cards[1].suit && cards[1].suit == cards[2].suit && cards[2].suit == cards[3].suit &&
            cards[3].suit == cards[4].suit) { id--; }
        }
        for(Card c : cards) {
            System.out.print(c.info() + " ");
        }
        System.out.println(" " + id + " " + names[(int)id]);

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
        return cards;
    }

}
