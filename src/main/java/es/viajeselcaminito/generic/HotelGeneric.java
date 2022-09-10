package es.viajeselcaminito.generic;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

@JsonRootName("hotels")
public class HotelGeneric {

    private String code;
    private String name;
    private String city;
    @SerializedName("rooms")
    private RoomGeneric[] roomGenerics;

    public HotelGeneric() {
    }

    public HotelGeneric(String code, String name, String city, RoomGeneric[] roomGenerics) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.roomGenerics = roomGenerics;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public RoomGeneric[] getRoomGenerics() {
        return roomGenerics;
    }

    public void setRoomGenerics(RoomGeneric[] roomGenerics) {
        this.roomGenerics = roomGenerics;
    }

    @Override
    public String toString() {
        return "\nHotelGeneric{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", roomGenerics=" + Arrays.toString(roomGenerics) +
                '}';
    }
}
