package es.viajeselcaminito.utilities;

public class Utils {

    public static RoomType getRoomType(String roomType) {
        switch (roomType) {
            case "st":
            case "standard":
                return RoomType.STANDARD;
            case "su":
            case "suite":
                return RoomType.SUITE;
        }
        return null;
    }

}
