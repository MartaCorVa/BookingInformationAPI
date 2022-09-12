package es.viajeselcaminito.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import es.viajeselcaminito.generic.HotelGeneric;
import es.viajeselcaminito.generic.HotelListGeneric;
import es.viajeselcaminito.utilities.Atalaya;
import es.viajeselcaminito.utilities.ResortHotels;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;


@Controller
public class HotelList {

    @RequestMapping(value = "/hotelList", method = RequestMethod.GET)
    @ResponseBody
    public static String getAllHotels() {
        
        try {

            // Get all information from Resort Hotels provider
            ArrayList<HotelGeneric> resortHotels = ResortHotels.getAllFromResort();

            // Get all information from Atalaya provider
            ArrayList<HotelGeneric> atalayaHotels = Atalaya.getAllFromAtalaya();

            ArrayList<HotelGeneric> hotels = new ArrayList<>();
            hotels.addAll(resortHotels);
            hotels.addAll(atalayaHotels);

            HotelListGeneric hotelListGeneric = new HotelListGeneric(hotels.toArray(new HotelGeneric[0]));

            Gson prettyHotels = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

            return prettyHotels.toJson(hotelListGeneric);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

}
