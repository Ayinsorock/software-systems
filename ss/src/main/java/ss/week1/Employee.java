package ss.week1;

/**
 * Employee class for exercise 4.7
 */
public class Employee {
    private static final int WORKWEEK = 40;
    private static final double OVERTIME_RATE_EXTRA = 0.5;

    private int hours;
    private double rate;

    public Employee () {
        this.hours = 60;
        this.rate = 15.00;
    }

    public double pay () {
        return (this.hours * this.rate) + (this.hours > Employee.WORKWEEK ? (this.hours - Employee.WORKWEEK) * Employee.OVERTIME_RATE_EXTRA * this.rate : 0);
    }
}
