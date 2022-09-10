package es.viajeselcaminito.models.atalaya;

import java.util.Arrays;

public class RoomListAtalaya {

    private RoomAtalaya[] rooms_type;

    public RoomListAtalaya(RoomAtalaya[] rooms_type) {
        this.rooms_type = rooms_type;
    }

    public RoomAtalaya[] getRooms_type() {
        return rooms_type;
    }

    public void setRooms_type(RoomAtalaya[] rooms_type) {
        this.rooms_type = rooms_type;
    }

    @Override
    public String toString() {
        return "\nRoomListAtalaya{" +
                "rooms_type=" + Arrays.toString(rooms_type) +
                '}';
    }

}
