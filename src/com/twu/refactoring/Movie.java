package com.twu.refactoring;

public class Movie {
    private String title;
    private MovieCategory priceCode;

    public Movie(String title, MovieCategory priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public void setPriceCode(MovieCategory arg) {
        priceCode = arg;
    }

    public String getTitle() {
        return title;
    }

    public double getAmount(int daysRented) {
        switch (priceCode) {
            case REGULAR:
                return ((daysRented > 2) ? (daysRented - 2) * 1.5 : 0) + 2;
            case NEW_RELEASE:
                return daysRented * 3;
            case CHILDREN:
                return ((daysRented > 3) ? (daysRented - 3) * 1.5 : 0) + 1.5;
        }

        return 0;
    }

    public int getFrequentRenterPoints(int daysRented) {
        return priceCode == MovieCategory.NEW_RELEASE && daysRented > 1? 2:1;
    }
}

