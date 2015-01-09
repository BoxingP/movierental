package com.twu.refactoring;

public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public String printAmount(String separator1, String separator2, String separator3) {
        return separator1 + movie.getTitle() + separator2 + getAmount() + separator3;
    }

    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }

    public double getAmount() {
        return movie.getAmount(daysRented);
    }

}