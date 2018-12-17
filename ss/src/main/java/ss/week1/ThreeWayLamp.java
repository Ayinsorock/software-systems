package ss.week1;

// Three way lamp as described in exercises 1.2, 2.4, 2.14
public class ThreeWayLamp {
    public static final int OFF = 0;
    public static final int LOW = 1;
    public static final int MEDIUM = 2;
    public static final int HIGH = 3;

    private int setting = OFF;

    private final int[] SETTINGS = {
            OFF,
            LOW,
            MEDIUM,
            HIGH
    };

    public int currentSetting () {
        return setting;
    }

    public void  switchSetting () {
        setting = (setting + 1) % SETTINGS.length;
    }
}
