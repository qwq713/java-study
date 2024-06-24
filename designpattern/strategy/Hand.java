package designpattern.strategy;

public enum Hand {
    ROCK("바위", 0),
    SCISSORS("가위", 1),
    PAPER("보", 2);

    private String name;
    private int handValue;

    private static final Hand[] hands = {ROCK, SCISSORS, PAPER};

    /**
     * 생성자는 외부에서 직접 호출 X ( private )
     * 외부에서 Hand.ROCK과 같이 enum을 호출할때 자동으로 값이 매핑되어 생성.
     * */
    Hand(String name, int handValue) {
        this.name = name;
        this.handValue = handValue;
    }

    public static Hand getHand(int handValue) {
        return hands[handValue];
    }

    private int fight(Hand h) {
        /* Hand 는 enum 클래스이므로 1개의 객체만 생성한다. 따라서 주소가 같으면 값도 같다. */
        if (this == h) {
            return 0;
        } else if ((this.handValue + 1) % 3 == h.handValue) {
            return 1;
        } else {
            return -1;
        }
    }

    public boolean isStronger(Hand h) {
        return fight(h) == 1;
    }

    public boolean isWeaker(Hand h) {
        return fight(h) == -1;
    }

    @Override
    public String toString() {
        return name;
    }
}
