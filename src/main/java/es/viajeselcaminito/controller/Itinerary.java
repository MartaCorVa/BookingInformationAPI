package es.viajeselcaminito.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import es.viajeselcaminito.generic.HotelGeneric;
import es.viajeselcaminito.generic.HotelListGeneric;
import es.viajeselcaminito.models.itinerary.HotelListItinerary;
import es.viajeselcaminito.models.itinerary.ItineraryCity;
import es.viajeselcaminito.utilities.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class Itinerary {

    @RequestMapping(value = "/itineraryCancun", method = RequestMethod.GET)
    @ResponseBody
    public static String getItinerary() {

        try {

            // Get all information from Resort Hotels provider
            ArrayList<HotelGeneric> resortHotels =  ResortHotels.getAllFromResort();

            // Get all information from Atalaya provider
            ArrayList<HotelGeneric> atalayaHotels = Atalaya.getAllFromAtalaya();

            // Create an ArrayList with all the hotels
            ArrayList<HotelGeneric> hotels = new ArrayList<>();
            hotels.addAll(resortHotels);
            hotels.addAll(atalayaHotels);

            // Create HotelListGeneric using the ArrayList
            HotelListGeneric hotelListGeneric = new HotelListGeneric(hotels.toArray(new HotelGeneric[0]));

            // Create the desired itinerary
            ItineraryCity[] itineraryCities = new ItineraryCity[2];
            itineraryCities[0] = new ItineraryCity("Cancun", MealPlan.AD, null, 5);
            itineraryCities[1] = new ItineraryCity("Malaga", MealPlan.PC, RoomType.SUITE, 3);
            
            ItineraryCalculator itineraryCalculator = new ItineraryCalculator();
            ArrayList<HotelListItinerary> itinerary = itineraryCalculator.doItinerary(hotelListGeneric, 700, 2, itineraryCities);

            Gson prettyHotels = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

            return prettyHotels.toJson(itinerary);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

}
