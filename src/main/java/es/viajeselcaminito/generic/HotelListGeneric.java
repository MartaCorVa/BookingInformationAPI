package es.viajeselcaminito.generic;

import java.util.Arrays;

public class HotelListGeneric {

    private HotelGeneric[] hotels;

    public HotelListGeneric(HotelGeneric[] hotels) {
        this.hotels = hotels;
    }

    public HotelGeneric[] getHotels() {
        return hotels;
    }

    public void setHotels(HotelGeneric[] hotels) {
        this.hotels = hotels;
    }

    @Override
    public String toString() {
        return "HotelListGeneric{" +
                "hotels=" + Arrays.toString(hotels) +
                '}';
    }

}
