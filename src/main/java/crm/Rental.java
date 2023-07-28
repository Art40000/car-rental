package crm;

public class Rental {

    private final Car car;
    private final int period;

    public Rental(Car car, int period) {
        this.car = car;
        this.period = period;
    }

    public int getPeriod() {
        return period;
    }

    public Car getCar() {
        return car;
    }
}
