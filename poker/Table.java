/*

private enum Suit { CLUB, DIAMOND, HEART, SPADE; }
private enum Value {
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);
    private int value;
    Value(int v) { this.value = v; }
    boolean compare(Value other) { return false; }
}

public void shuffle() {
    for (int i = 0; i < size; i++) {
        int c = (int) (Math.random() * (i + 1));
        Card swap = cards[c];
        cards[c] = cards[i];
        cards[i] = swap;
    }
}

*/
