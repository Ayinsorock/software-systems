package ss.week1;

public class DollarsAndCentsCounter {
    private int dollars;
    private int cents;

    public DollarsAndCentsCounter () {
        dollars = 0;
        cents = 0;
    }

    public void reset () {
        dollars = 0;
        cents = 0;
    }

    public int dollars () {
        return dollars;
    }
    public int cents () {
        return cents;
    }

    public void add (int additionalDollars, int additionalCents) {
        dollars += additionalDollars;
        cents += additionalCents;

        dollars += cents / 100;
        cents = cents % 100;
    }
}
