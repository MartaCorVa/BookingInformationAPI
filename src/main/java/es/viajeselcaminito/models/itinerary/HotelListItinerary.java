package es.viajeselcaminito.models.itinerary;

import java.util.Arrays;

public class HotelListItinerary {

    private HotelItinerary[] hotels;

    public HotelListItinerary() {
    }
    public HotelListItinerary(HotelItinerary[] hotels) {
        this.hotels = hotels;
    }

    public HotelItinerary[] getHotels() {
        return hotels;
    }

    public void setHotels(HotelItinerary[] hotels) {
        this.hotels = hotels;
    }

    @Override
    public String toString() {
        return "\nHotelListItinerary{" +
                "hotels=" + Arrays.toString(hotels) +
                '}';
    }

}
