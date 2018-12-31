//package poker

public class Table {
    protected static int count = 0;

    private int id;
    private String name;

    private Player[] players;

    private Hand[] hands;
    private Card[] community;

    private long[] pots;
    private int[][] side;

    private int ante;
    private int sb;
    private int bb;

    public Table() {
        this(count,"test");
    }
    public Table(int i, String s) {
        this(3,i,s);
    }
    public Table(int p, int i, String s) {
        this(p,i,s,0,0,0);
    }
    public Table(int p, int i, String s, int _sb, int _bb, int a) {
        this.id = i;
        this.name = s;

        this.players = new Player[p];
        this.hands = new Hand[p];
        this.side = new int[p][p];
        this.pots = new long[p];

        this.sb = _sb;
        this.bb = _bb;
        this.ante = a;

        count++;
        reset();
    }

    public void reset() {
        for(int p = 0; p < players.length; p++) {
            players[p] = null;
            hands[p] = null;
            pots[p] = 0;
            for(int q = 0; q < players.length; q++) {
                side[p][q] = -1;
            }
        }
        return;
    }
    //flop turn river
    //dealer & blinds
    //betting

}
