package es.viajeselcaminito.models.atalaya;

import es.viajeselcaminito.utilities.RoomType;

public class MealPlanAtalaya {

    private String code;
    private String name;
    private String hotel;
    private RoomType roomType;
    private int price;

    public MealPlanAtalaya() {
    }

    public MealPlanAtalaya(String code, String name, String hotel, RoomType roomType, int price) {
        this.code = code;
        this.name = name;
        this.hotel = hotel;
        this.roomType = roomType;
        this.price = price;
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

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nMealPlanAtalaya{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", hotel='" + hotel + '\'' +
                ", roomType=" + roomType +
                ", price=" + price +
                '}';
    }
}
