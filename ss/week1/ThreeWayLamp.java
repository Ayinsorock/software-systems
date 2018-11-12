package ss.week1;

// Three way lamp as described in exercises 1.2, 2.4, 2.14
public class ThreeWayLamp {
    private int setting = 0;
    private final String[] SETTINGS = {
            "OFF",
            "LOW",
            "MEDIUM",
            "HIGH"
    };

    public static void main (String[] args) {
        ThreeWayLamp myLamp = new ThreeWayLamp();

        System.out.println(myLamp.currentSetting()); // LOW

        myLamp.switchSetting(); // LOW
        myLamp.switchSetting(); // MEDIUM

        System.out.println(myLamp.currentSetting()); // MEDIUM

        myLamp.switchSetting(); // HIGH
        myLamp.switchSetting(); // OFF
        myLamp.switchSetting(); // LOW

        System.out.println(myLamp.currentSetting()); // LOW
    }

    public String currentSetting () {
        return SETTINGS[setting];
    }

    public void  switchSetting () {
        setting = (setting + 1) % SETTINGS.length;
    }
}