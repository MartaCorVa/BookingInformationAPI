package es.viajeselcaminito.models.itinerary;

import es.viajeselcaminito.utilities.MealPlan;
import es.viajeselcaminito.utilities.RoomType;

public class ItineraryCity {

    private String city;
    private MealPlan mealPlan;
    private RoomType roomType;
    private int nights;

    public ItineraryCity(String city, MealPlan mealPlan, RoomType roomType, int nights) {
        this.city = city;
        this.mealPlan = mealPlan;
        this.roomType = roomType;
        this.nights = nights;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public MealPlan getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    @Override
    public String toString() {
        return "\nItineraryCity{" +
                "city='" + city + '\'' +
                ", mealPlan=" + mealPlan +
                ", roomType=" + roomType +
                ", nights=" + nights +
                '}';
    }
}
