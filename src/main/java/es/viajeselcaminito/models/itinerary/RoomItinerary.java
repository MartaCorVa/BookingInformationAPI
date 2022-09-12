package es.viajeselcaminito.models.itinerary;

import com.google.gson.annotations.SerializedName;
import es.viajeselcaminito.utilities.MealPlan;
import es.viajeselcaminito.utilities.RoomType;

public class RoomItinerary {

    private String name;
    @SerializedName("room_type")
    private RoomType roomType;
    @SerializedName("meal_plan")
    private MealPlan mealPlan;
    private int price;
    private int nights;

    public RoomItinerary() {
    }

    public RoomItinerary(String name, RoomType roomType, MealPlan mealPlan, int price, int nights) {
        this.name = name;
        this.roomType = roomType;
        this.mealPlan = mealPlan;
        this.price = price;
        this.nights = nights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public MealPlan getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    @Override
    public String toString() {
        return "\nRoomItinerary{" +
                "name='" + name + '\'' +
                ", roomType=" + roomType +
                ", mealPlan=" + mealPlan +
                ", price=" + price +
                ", nights=" + nights +
                '}';
    }
}
