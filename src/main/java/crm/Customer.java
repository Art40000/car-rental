package crm;

import java.util.LinkedList;

import static crm.Car.CarType.*;

public class Customer {

    private final String name;
    private final LinkedList<Rental> rentals;

    public Customer(String name, LinkedList<Rental> rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int loyaltyPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental each : rentals) {
            double thisAmount = 0;
            //determine amounts for each line
            switch (each.getCar().getPriceCode()) {
                case SPORT -> {
                    thisAmount += 30;
                    if (each.getPeriod() > 2)
                        thisAmount += (each.getPeriod() - 2) * 30;
                }
                case REGULAR -> thisAmount += each.getPeriod() * 10;
                case ELECTRICAL -> {
                    thisAmount += 15;
                    if (each.getPeriod() > 3)
                        thisAmount += (each.getPeriod() - 3) * 15;
                }
            }
            // add frequent renter points
            loyaltyPoints ++;
            // add bonus for a two day new release rental
            if ((each.getCar().getPriceCode() == REGULAR) && each.getPeriod() > 1)
                loyaltyPoints ++;
            //show figures for this rental
            result += "\t" + each.getCar().getTitle()+ "\t" + thisAmount + " $\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount price is " + totalAmount + " $\n";
        result += "You earned " + loyaltyPoints + " loyalty points";
        return result;
    }
}
