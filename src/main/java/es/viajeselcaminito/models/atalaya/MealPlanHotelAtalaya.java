package es.viajeselcaminito.models.atalaya;

import es.viajeselcaminito.utilities.RoomType;

public class MealPlanHotelAtalaya {

    private String code;
    private RoomType room;
    private int price;

    public MealPlanHotelAtalaya() {
    }

    public MealPlanHotelAtalaya(String code, RoomType room, int price) {
        this.code = code;
        this.room = room;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public RoomType getRoom() {
        return room;
    }

    public void setRoom(RoomType room) {
        this.room = room;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nMealPlanHotelAtalaya{" +
                "code='" + code + '\'' +
                ", room=" + room +
                ", price='" + price + '\'' +
                '}';
    }
}