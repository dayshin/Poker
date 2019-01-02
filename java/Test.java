public class Test {
    public static void main(String[] args) {
        Hand h = new Hand();
                
        //straight flush
        for(int i = 0; i < 5; i++) {
            h.cards[i] = new Card(i,0);
        }
        h.evaluate();

        //full house
        for(int i = 0; i < 5; i++) {
            h.cards[i] = new Card(i%2,(i+1)%4);
        }
        h.evaluate();

        //flush
        int suit = (int)(Math.random()*4);
        for(int i = 0; i < 5; i++) {
            h.cards[i] = new Card(i*2,suit);
        }
        h.evaluate();

        //straight
        for(int i = 0; i < 5; i++) {
            h.cards[i] = new Card(i,(int)(Math.random()*4));
        }
        h.evaluate();

        //trips
        for(int i = 0; i < 5; i++) {
            h.cards[i] = new Card((i/3)*(int)(Math.random()*10),i%4);
        }
        h.evaluate();

        //two pair
        for(int i = 0; i < 5; i++) {
            h.cards[i] = new Card(i/2,i%4);
        }
        h.evaluate();


    }
}
