package crm;

import java.util.LinkedList;
import java.util.List;

import static crm.Car.CarType.*;

public class Main {

    public static final Car FERRARI = new Car("Ferrari F40", SPORT);
    public static final Car FORD = new Car("Ford Focus", REGULAR);
    public static final Car TESLA = new Car("Tesla model 3", ELECTRICAL);

    public static void main(String[] args) {
        LinkedList<Rental> rentals = new LinkedList();
        rentals.add(new Rental(FERRARI, 1));
        rentals.add(new Rental(FORD, 4));
        rentals.add(new Rental(TESLA, 5));

        Customer customer = new Customer("Vasiliy Pupkin", rentals);

        System.out.println(customer.statement());
    }
}
