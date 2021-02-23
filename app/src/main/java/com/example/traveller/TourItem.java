package com.example.traveller;
import java.io.Serializable;

public class TourItem implements Serializable {
    private static int ID = 1;
    private int id;
    private String destination;
    private String resort;
    private String dateStart;
    private String dateEnd;
    private String departurePlace;
    private boolean ifFavorite;
    private int rate;
    private int mainImageId;
    private int price;

    public TourItem(String destination, String resort, String departurePlace,
                    int rate, int mainImageId, int price, String dateStart, String dateEnd){
        this.id = ID++;
        this.destination = destination;
        this.resort = resort;
        this.dateEnd =dateEnd;
        this.dateStart = dateStart;
        this.departurePlace = departurePlace;
        this.rate = rate;
        this.ifFavorite = false;
        this.mainImageId = mainImageId;
        this.price = price;
    }

    public String getDateStart() {
        return dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public int getPrice() {
        return price;
    }

    public int getMainImageId() {
        return mainImageId;
    }

    public String getDestination() {
        return destination;
    }

    public int getId() {
        return id;
    }

    public String getResort() {
        return resort;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public int getRate() {
        return rate;
    }

    public boolean isFavorite() {
        return ifFavorite;
    }

    public void setFavorite(boolean ifFavorite) {
        this.ifFavorite = ifFavorite;
    }
}
