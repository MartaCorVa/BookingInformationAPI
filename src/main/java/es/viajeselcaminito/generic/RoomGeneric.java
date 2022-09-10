package es.viajeselcaminito.generic;

import com.google.gson.annotations.SerializedName;
import es.viajeselcaminito.utilities.MealPlan;
import es.viajeselcaminito.utilities.RoomType;

public class RoomGeneric {

    private String name;
    @SerializedName(value="room_type")
    private RoomType roomType;
    @SerializedName(value="meal_plan")
    private MealPlan mealPlan;
    private int price;

    public RoomGeneric() {
    }

    public RoomGeneric(String name, RoomType roomType, MealPlan mealPlan, int price) {
        this.name = name;
        this.roomType = roomType;
        this.mealPlan = mealPlan;
        this.price = price;
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

    public void setRoomType(String roomType) {
        switch (roomType) {
            case "st":
            case "standard":
                this.roomType = RoomType.STANDARD;
                break;
            case "su":
            case "suite":
                this.roomType = RoomType.SUITE;
                break;
        }
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public MealPlan getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(String mealPlan) {
        switch (mealPlan) {
            case "pc":
                this.mealPlan = MealPlan.PC;
                break;
            case "mp":
                this.mealPlan = MealPlan.MP;
                break;
            case "sa":
                this.mealPlan = MealPlan.SA;
                break;
            case "ad":
                this.mealPlan = MealPlan.AD;
                break;
        }
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

    @Override
    public String toString() {
        return "\nRoomGeneric{" +
                "name='" + name + '\'' +
                ", roomType=" + roomType +
                ", mealPlan=" + mealPlan +
                ", price=" + price +
                '}';
    }

}
