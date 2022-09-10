package es.viajeselcaminito.models.resort;

public class MealPlanResort {

    private String code;
    private String name;
    private String hotel;
    private String room_type;
    private int price;

    public MealPlanResort(String code, String name, String hotel, String room_type, int price) {
        this.code = code;
        this.name = name;
        this.hotel = hotel;
        this.room_type = room_type;
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

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nMealPlanResort{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", hotel='" + hotel + '\'' +
                ", room_type=" + room_type +
                ", price=" + price +
                '}';
    }
}