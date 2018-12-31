//package poker
public class Player {

    private String name;
    private long bank;

    public Player() {
        this("bot",-1);
    }
    public Player(String n, int b) {
        this.name = n;
        this.bank = b;
    }

    public String info() {
        return name + ": " + bank;
    }
    public void print() {
        System.out.println(this.info());
    }

    public boolean buy(int in) {
        if(bank >= in) {
            bank -= in;
            return true;
        }
        return false;
    }
    public void receive(int out) {
        bank += out;
    }

}
