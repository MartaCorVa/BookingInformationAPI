package es.viajeselcaminito.models.itinerary;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

@JsonRootName("hotels")
public class HotelItinerary {

    private String code;
    private String name;
    private String city;
    @SerializedName("room")
    private RoomItinerary[] roomItineraries;

    public HotelItinerary() {
    }

    public HotelItinerary(String code, String name, String city, RoomItinerary[] roomItineraries) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.roomItineraries = roomItineraries;
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

    public RoomItinerary[] getRoomItineraries() {
        return roomItineraries;
    }

    public void setRoomItineraries(RoomItinerary[] roomItineraries) {
        this.roomItineraries = roomItineraries;
    }

    @Override
    public String toString() {
        return "\nHotelItinerary{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", roomItineraries=" + Arrays.toString(roomItineraries) +
                '}';
    }
}