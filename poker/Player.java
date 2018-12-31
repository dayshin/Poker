//package poker
public class Player {
    private String name;
    private Card[] hole;
    private int bank;
    //private int chip;
    public Player() {
        name = "bot";
        bank = -1;
        hole = new Card[2];
        //chip = 0;
    }

    public boolean receive(Card card) {
        return false;
    }
    public void print() {
        for(Card c : hole) {
            c.print();
        }
        System.out.println();
    }

}
