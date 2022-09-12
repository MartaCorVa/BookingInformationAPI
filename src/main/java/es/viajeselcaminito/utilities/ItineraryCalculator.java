package es.viajeselcaminito.utilities;

import es.viajeselcaminito.generic.HotelGeneric;
import es.viajeselcaminito.generic.HotelListGeneric;
import es.viajeselcaminito.generic.RoomGeneric;
import es.viajeselcaminito.models.itinerary.HotelItinerary;
import es.viajeselcaminito.models.itinerary.HotelListItinerary;
import es.viajeselcaminito.models.itinerary.ItineraryCity;
import es.viajeselcaminito.models.itinerary.RoomItinerary;

import java.util.ArrayList;

public class ItineraryCalculator {

    public static int calcPrice(int price, int nights) {

        return price * nights;

    }

    public static HotelItinerary createHotelItinerary(String code, String name, String city, RoomItinerary[] rooms) {

        return new HotelItinerary(code, name, city, rooms);

    }

    public static ArrayList<HotelListItinerary> bestOption(ArrayList<HotelItinerary> hotels, int totalPrice) {

        ArrayList<HotelListItinerary> itinerary = new ArrayList<>();

        ArrayList<HotelItinerary[]> lista = new ArrayList<>();

        // Get the hotels
        HotelItinerary firstHotel = hotels.get(0);
        HotelItinerary secondHotel = hotels.get(1);

        for (RoomItinerary roomFirstHotel : firstHotel.getRoomItineraries()) {

            for (RoomItinerary roomSecondHotel : secondHotel.getRoomItineraries()) {

                // Check if the total price exceeds the limit
                if ((roomFirstHotel.getPrice() + roomSecondHotel.getPrice()) <= totalPrice) {

                    // Create the combination of hotels and rooms
                    RoomItinerary[] rooms = new RoomItinerary[]{roomFirstHotel};
                    HotelItinerary firstHotelItinerary = createHotelItinerary(firstHotel.getCode(), firstHotel.getName(),
                            firstHotel.getCity(),rooms);

                    rooms = new RoomItinerary[]{roomSecondHotel};

                    HotelItinerary secondHotelItinerary = createHotelItinerary(secondHotel.getCode(), secondHotel.getName(),
                            secondHotel.getCity(), rooms);

                    // Add the hotels to the list
                    lista.add(new HotelItinerary[]{firstHotelItinerary, secondHotelItinerary});

                }

            }

        }

        for (HotelItinerary[] hotelItinerary : lista) {
            itinerary.add(new HotelListItinerary(hotelItinerary));
        }

        return itinerary;

    }

    public static ArrayList<HotelItinerary> setPrices(ArrayList<HotelGeneric> hotels, int guests, int totalPrice, ItineraryCity[] itineraryCities) {

        ArrayList<HotelItinerary> hotelItineraries = new ArrayList<>();
        ArrayList<RoomItinerary> roomItineraries = new ArrayList<>();

        for (HotelGeneric hotel : hotels) {

            for (RoomGeneric room : hotel.getRoomGenerics()) {

                for (ItineraryCity itineraryHotel : itineraryCities) {

                    if (itineraryHotel.getCity().equals(hotel.getCity())) {

                        // Create the rooms with the total prices and nights
                        RoomItinerary roomItinerary = new RoomItinerary();
                        roomItinerary.setName(room.getName());
                        roomItinerary.setRoomType(room.getRoomType());
                        roomItinerary.setMealPlan(room.getMealPlan());
                        roomItinerary.setPrice(calcPrice(room.getPrice(), itineraryHotel.getNights()));
                        roomItinerary.setNights(itineraryHotel.getNights());

                        roomItineraries.add(roomItinerary);

                    }

                }

            }

            // Create the hotels with the rooms
            HotelItinerary hotelItinerary = createHotelItinerary(hotel.getCode(), hotel.getName(),
                    hotel.getCity(), roomItineraries.toArray(new RoomItinerary[0]));

            hotelItineraries.add(hotelItinerary);
            roomItineraries.clear();

        }

        return hotelItineraries;

    }

    public static ArrayList<HotelGeneric> filter(ArrayList<HotelGeneric> hotels, ItineraryCity[] itineraryCities) {

        ArrayList<HotelGeneric> possibleHotels = new ArrayList<>();
        ArrayList<RoomGeneric> possibleRooms = new ArrayList<>();

        for (HotelGeneric hotel : hotels) {

            for (RoomGeneric room : hotel.getRoomGenerics()) {

                for (ItineraryCity itineraryHotel : itineraryCities) {

                    // Filter by city
                    if (hotel.getCity().equals(itineraryHotel.getCity())) {

                        // Filter by meal plan
                        if (room.getMealPlan() == itineraryHotel.getMealPlan()) {

                            // Filter by room type
                            if (room.getRoomType() == itineraryHotel.getRoomType() ||
                                    itineraryHotel.getRoomType() == null) {

                                // Get possible rooms
                                possibleRooms.add(room);

                            }

                        }

                    }

                }

            }

            // Create the hotels with the corresponding rooms
            hotel.setRoomGenerics(possibleRooms.toArray(new RoomGeneric[0]));
            possibleHotels.add(hotel);
            possibleRooms.clear();

        }

        return possibleHotels;

    }
    public static ArrayList<HotelGeneric> searchHotel(HotelListGeneric hotels, ItineraryCity[] itineraryCities) {

        ArrayList<HotelGeneric> possibleHotels = new ArrayList<>();

        for (HotelGeneric hotel : hotels.getHotels()) {

            for (ItineraryCity city : itineraryCities) {

                // Filter by city
                if ( city.getCity().equals(hotel.getCity()) ) {

                    possibleHotels.add(hotel);

                }

            }

        }

        return possibleHotels;

    }

    public static ArrayList<HotelListItinerary> doItinerary(HotelListGeneric hotels, int totalPrice, int guests, ItineraryCity[] itineraryCities) {

        ArrayList<HotelGeneric> possibleHotels = searchHotel(hotels, itineraryCities);

        ArrayList<HotelGeneric> hotelsFiltered = filter(possibleHotels, itineraryCities);

        ArrayList<HotelItinerary> hotelsWithPrice = setPrices(hotelsFiltered, guests, totalPrice, itineraryCities);

        ArrayList<HotelListItinerary> hotelItineraries = bestOption(hotelsWithPrice, totalPrice);

        return hotelItineraries;

    }

}
