package es.viajeselcaminito.utilities;

import com.google.gson.Gson;
import es.viajeselcaminito.generic.HotelGeneric;
import es.viajeselcaminito.generic.RoomGeneric;
import es.viajeselcaminito.models.resort.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import static es.viajeselcaminito.utilities.Utils.getRoomType;

public class ResortHotels {

    public static ArrayList<HotelGeneric> getAllFromResort() throws IOException {
        String urlGetHotelsResort = "http://www.mocky.io/v2/5e4e43272f00006c0016a52b";
        String urlGetRegimenResort = "http://www.mocky.io/v2/5e4a7dd02f0000290097d24b";

        // Get all hotels and rooms from Resort Hotels
        BBDDManager BBDDManager = new BBDDManager(new URL(urlGetHotelsResort));
        String content = BBDDManager.getAllHotels(BBDDManager.getUrl());

        Gson gson = new Gson();
        HotelListResort hotels = gson.fromJson(content, HotelListResort.class);

        // Get all meal plans
        BBDDManager = new BBDDManager(new URL(urlGetRegimenResort));
        String mealPlans = BBDDManager.getAllHotels(BBDDManager.getUrl());

        gson = new Gson();
        MealPlanListResort mealPlanListResort = gson.fromJson(mealPlans, MealPlanListResort.class);

        ArrayList<HotelGeneric> hotelList = createHotelGeneric(hotels.getHotels());
        hotelList = asignMealPlanToHotel(hotelList, mealPlanListResort);

        return hotelList;

    }

    public static ArrayList<HotelGeneric> createHotelGeneric(HotelResort[] hotels) {
        ArrayList<HotelGeneric> hotelList = new ArrayList<>();
        HotelGeneric hotelGeneric;
        RoomGeneric roomGeneric;

        for (HotelResort hotelResort : hotels) {

            // Initialize the generic hotel
            hotelGeneric = new HotelGeneric();

            // Set all generic fields
            hotelGeneric.setCode(hotelResort.getCode());
            hotelGeneric.setName(hotelResort.getName());
            hotelGeneric.setCity(hotelResort.getLocation());

            // Get all rooms
            RoomResort[] rooms = hotelResort.getRooms();

            // Hotel room list
            RoomGeneric[] roomGenerics = new RoomGeneric[rooms.length];

            for (int i = 0; i < rooms.length; i++) {
                // Initialize the generic room
                roomGeneric = new RoomGeneric();

                // Set all generic fields
                roomGeneric.setName(rooms[i].getName());
                roomGeneric.setRoomType(rooms[i].getCode());

                roomGenerics[i] = roomGeneric;
            }

            // Insert the rooms into the hotel
            hotelGeneric.setRoomGenerics(roomGenerics);

            // Add hotel to the list
            hotelList.add(hotelGeneric);

        }

        return hotelList;

    }

    public static ArrayList<HotelGeneric> asignMealPlanToHotel(ArrayList<HotelGeneric> hotels, MealPlanListResort mealPlanListResort) {

        MealPlanResort[] meals = mealPlanListResort.getRegimenes();
        ArrayList<RoomGeneric> rooms = new ArrayList<>();
        RoomGeneric[] templateRooms;
        RoomGeneric roomGeneric;

        for (HotelGeneric hotel : hotels) {

            templateRooms = hotel.getRoomGenerics();

            for (int i = 0; i <= meals.length - 1 ; i++) {

                if (hotel.getCode().equals(meals[i].getHotel())) {

                    for (RoomGeneric templateRoom : templateRooms) {

                        if (templateRoom.getRoomType() == getRoomType(meals[i].getRoom_type())) {

                            roomGeneric = new RoomGeneric();
                            roomGeneric.setName(templateRoom.getName());
                            roomGeneric.setRoomType(templateRoom.getRoomType());
                            roomGeneric.setMealPlan(meals[i].getCode());
                            roomGeneric.setPrice(meals[i].getPrice());

                            rooms.add(roomGeneric);

                        }

                    }

                }

            }

            RoomGeneric[] roomArray = new RoomGeneric[rooms.size()];
            hotel.setRoomGenerics(rooms.toArray(roomArray));
            rooms = new ArrayList<>();

        }

        return hotels;

    }

}
