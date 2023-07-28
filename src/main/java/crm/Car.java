package crm;

public class Car {

    private final String title;
    private final CarType priceCode;

    public enum CarType {
        SPORT, REGULAR, ELECTRICAL
    }

    public Car(String title, CarType priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public CarType getPriceCode() {
        return priceCode;
    }

    public String getTitle (){
        return title;
    }
}
