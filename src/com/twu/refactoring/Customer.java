package com.twu.refactoring;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Rental> rentalList = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentalList.add(arg);
    }

    public String statement() {
        String result = "Rental Record for " + name + "\n";
        result += getEachRentalAmount("\t", "\t", "\n");
        result += "Amount owed is " + getTotalAmount() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";

        return result;
    }

    public String htmlStatement() {
        String result = "<H1>Rentals for <EM>" + name + "</EM></H1><P>";
        result += getEachRentalAmount("", ": ", "<BR>");
        result += "<P>You owe <EM>" + getTotalAmount() + "</EM>";
        result += "<P>On this rental you earned <EM>" + getTotalFrequentRenterPoints() + "</EM> frequent renter points<P>\n";

        return result;
    }

    private String getEachRentalAmount(String character1, String character2, String character3) {
        String eachRental = "";
        for (Rental each : rentalList) {
            eachRental += each.printAmount(character1, character2, character3);
        }

        return eachRental;
    }

    private double getTotalAmount() {
        double totalAmount = 0;
        for (Rental each : rentalList) {
            totalAmount += each.getAmount();
        }

        return totalAmount;
    }

    private int getTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental each : rentalList) {
            frequentRenterPoints += each.getFrequentRenterPoints();
        }

        return frequentRenterPoints;
    }
}
