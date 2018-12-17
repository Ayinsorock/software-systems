package ss.week1;

public class DollarsAndCentsCounter {
    private int dollars;
    private int cents;

    /**
     * @param dollars initial amount of dollars
     * @param cents initial amount of cents
     *
     * @require dollars >= 0
     *            cents >= 0
     */
    public DollarsAndCentsCounter (int dollars, int cents) {
        assert dollars >= 0 : "precondition: dollars (" + dollars + ") >= 0";
        assert cents >= 0 : "precondition: cents (" + cents + ") >= 0";

        this.dollars = dollars;
        this.cents = cents;
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
