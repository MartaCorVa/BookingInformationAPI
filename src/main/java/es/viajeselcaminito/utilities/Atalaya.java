package es.viajeselcaminito.utilities;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import es.viajeselcaminito.generic.HotelGeneric;
import es.viajeselcaminito.generic.RoomGeneric;
import es.viajeselcaminito.models.atalaya.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Set;

public class Atalaya {

    public static ArrayList<HotelGeneric> getAllFromAtalaya() throws IOException {
        String urlGetHotelsAtalaya = "http://www.mocky.io/v2/5e4a7e4f2f00005d0097d253";
        String urlGetRoomsAtalaya = "https://run.mocky.io/v3/132af02e-8beb-438f-ac6e-a9902bc67036";
        String urlGetMealPlan = "https://www.mocky.io/v2/5e4a7e282f0000490097d252";

        // Get Hotels
        BBDDManager BBDDManager = new BBDDManager(new URL(urlGetHotelsAtalaya));
        String content = BBDDManager.getAllHotels(BBDDManager.getUrl());

        Gson gson = new Gson();
        HotelListAtalaya hotelListAtalaya = gson.fromJson(content, HotelListAtalaya.class);

        // Get rooms
        BBDDManager = new BBDDManager(new URL(urlGetRoomsAtalaya));
        String contentRoom = BBDDManager.getAllHotels(BBDDManager.getUrl());
        RoomListAtalaya roomListAtalaya = gson.fromJson(contentRoom, RoomListAtalaya.class);

        // Get Meal Plans
        BBDDManager = new BBDDManager(new URL(urlGetMealPlan));
        String contentMealPlan = BBDDManager.getAllHotels(BBDDManager.getUrl());
        ArrayList<MealPlanAtalaya> mealPlanAtalayaList = getMealPlanAtalaya(contentMealPlan);

        // Create generic hotel list
        ArrayList<HotelGeneric> hotelGenericList = createFinalHotelGeneric(hotelListAtalaya,roomListAtalaya, mealPlanAtalayaList);

        return hotelGenericList;

    }

    public static ArrayList<HotelGeneric> createFinalHotelGeneric(HotelListAtalaya hotelListAtalaya, RoomListAtalaya roomListAtalaya, ArrayList<MealPlanAtalaya> mealPlanAtalayaList) {

        ArrayList<HotelGeneric> hotelGenericList = createHotelGeneric(hotelListAtalaya);
        ArrayList<RoomGeneric> roomGenericList = createRoomGeneric(roomListAtalaya);
        ArrayList<HotelGeneric> hotels = new ArrayList<>();

        ArrayList<RoomGeneric> rooms = new ArrayList<>();

        for (HotelGeneric hotelGeneric: hotelGenericList) {

            for (RoomGeneric templateGeneric: roomGenericList) {

                for (MealPlanAtalaya meal: mealPlanAtalayaList) {

                    if ( hotelGeneric.getCode().equals(meal.getHotel()) ) {

                        if ( meal.getRoomType() == templateGeneric.getRoomType() ) {

                            RoomGeneric roomGeneric = new RoomGeneric();

                            roomGeneric.setName(templateGeneric.getName());
                            roomGeneric.setRoomType(templateGeneric.getRoomType());
                            roomGeneric.setMealPlan(meal.getCode());
                            roomGeneric.setPrice(meal.getPrice());

                            rooms.add(roomGeneric);
                        }

                    }

                }

            }
            hotelGeneric.setRoomGenerics(rooms.toArray(new RoomGeneric[0]));
            rooms.clear();
            hotels.add(hotelGeneric);
        }

        return hotels;
    }

    public static ArrayList<RoomGeneric> createRoomGeneric(RoomListAtalaya roomListAtalaya) {

        ArrayList<RoomGeneric> roomGenericList = new ArrayList<>();
        RoomGeneric roomGeneric;

        for (RoomAtalaya roomAtalaya: roomListAtalaya.getRooms_type()) {

            roomGeneric = new RoomGeneric();

            roomGeneric.setName(roomAtalaya.getName());
            roomGeneric.setRoomType(roomAtalaya.getCode());

            roomGenericList.add(roomGeneric);

        }

        return roomGenericList;
    }


    public static ArrayList<HotelGeneric> createHotelGeneric(HotelListAtalaya hotelListAtalaya) {

        ArrayList<HotelGeneric> hotelGenericList = new ArrayList<>();
        HotelGeneric hotelGeneric;

        for (HotelAtalaya hotelAtalaya : hotelListAtalaya.getHotels()) {

            hotelGeneric = new HotelGeneric();

            hotelGeneric.setCode(hotelAtalaya.getCode());
            hotelGeneric.setName(hotelAtalaya.getName());
            hotelGeneric.setCity(hotelAtalaya.getCity());

            hotelGenericList.add(hotelGeneric);
        }

        return hotelGenericList;

    }


    public static ArrayList<MealPlanAtalaya> getMealPlanAtalaya(String content) {

        JsonObject jsonObject = new Gson().fromJson(content, JsonObject.class);

        JsonArray mealPlans = jsonObject.getAsJsonObject().get("meal_plans").getAsJsonArray();

        // Atalaya meal plans
        ArrayList<MealPlanAtalaya> mealPlanAtalayaList = new ArrayList<>();
        MealPlanAtalaya mealPlanAtalaya = new MealPlanAtalaya();

        // Meal plan by hotel
        MealPlanHotelAtalaya mealPlanHotelAtalaya = new MealPlanHotelAtalaya();

        for (int i = 0; i <= mealPlans.size() - 1; i++) {

            JsonObject mealPlan = mealPlans.get(i).getAsJsonObject();

            // Get hotel array
            JsonObject hotel = mealPlan.get("hotel").getAsJsonObject();

            Set<String> keys = hotel.getAsJsonObject().keySet();

            for (String key : keys) {

                // Get rooms
                JsonArray rooms = hotel.get(key).getAsJsonArray();

                for (int j = 0; j <= rooms.size() - 1; j++) {

                    mealPlanAtalaya = new MealPlanAtalaya();
                    // Get code
                    mealPlanAtalaya.setCode(mealPlan.get("code").toString().replace("\"", ""));
                    mealPlanAtalaya.setName(mealPlan.get("name").toString().replace("\"", ""));

                    mealPlanHotelAtalaya =
                            new MealPlanHotelAtalaya(key.replace("\"", ""),
                                    Utils.getRoomType(rooms.get(j).getAsJsonObject().get("room").toString().replace("\"", "")),
                                    Integer.parseInt(rooms.get(j).getAsJsonObject().get("price").toString()));

                    mealPlanAtalaya.setHotel(mealPlanHotelAtalaya.getCode());
                    mealPlanAtalaya.setRoomType(mealPlanHotelAtalaya.getRoom());
                    mealPlanAtalaya.setPrice(mealPlanHotelAtalaya.getPrice());

                    mealPlanAtalayaList.add(mealPlanAtalaya);

                }

            }

        }

        return mealPlanAtalayaList;

    }

}
