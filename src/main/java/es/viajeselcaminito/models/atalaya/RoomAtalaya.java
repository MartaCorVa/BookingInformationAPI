package es.viajeselcaminito.models.atalaya;

import java.util.Arrays;

public class RoomAtalaya {

    private String[] hotels;
    private String code;
    private String name;

    public RoomAtalaya(String[] hotels, String code, String name) {
        this.hotels = hotels;
        this.code = code;
        this.name = name;
    }

    public String[] getHotels() {
        return hotels;
    }

    public void setHotels(String[] hotels) {
        this.hotels = hotels;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nRoomAtalaya{" +
                "hotels=" + Arrays.toString(hotels) +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
