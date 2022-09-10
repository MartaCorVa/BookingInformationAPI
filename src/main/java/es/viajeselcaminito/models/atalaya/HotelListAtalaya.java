package es.viajeselcaminito.models.atalaya;

import java.util.Arrays;

public class HotelListAtalaya {

    private HotelAtalaya[] hotels;

    public HotelListAtalaya(HotelAtalaya[] hotels) {
        this.hotels = hotels;
    }

    public HotelAtalaya[] getHotels() {
        return hotels;
    }

    public void setHotels(HotelAtalaya[] hotels) {
        this.hotels = hotels;
    }

    @Override
    public String toString() {
        return "\nHotelListAtalaya{" +
                "hotels=" + Arrays.toString(hotels) +
                '}';
    }

}