package es.viajeselcaminito.models.resort;

import java.util.Arrays;

public class HotelResort {

    private String code;
    private String name;
    private String location;
    private RoomResort[] rooms;

    public HotelResort(String code, String name, String location, RoomResort[] rooms) {
        this.code = code;
        this.name = name;
        this.location = location;
        this.rooms = rooms;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public RoomResort[] getRooms() {
        return rooms;
    }

    public void setRooms(RoomResort[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "\nHotelResort{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", rooms=" + Arrays.toString(rooms) +
                '}';
    }

}
