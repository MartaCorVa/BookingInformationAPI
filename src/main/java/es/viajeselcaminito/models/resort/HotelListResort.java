package es.viajeselcaminito.models.resort;

import java.util.Arrays;

public class HotelListResort {

    private HotelResort[] hotels;

    public HotelListResort(HotelResort[] hotels) {
        this.hotels = hotels;
    }

    public HotelResort[] getHotels() {
        return hotels;
    }

    public void setHotels(HotelResort[] hotels) {
        this.hotels = hotels;
    }

    @Override
    public String toString() {
        return "\nHotelListResort{" +
                "hotels=" + Arrays.toString(hotels) +
                '}';
    }
}
