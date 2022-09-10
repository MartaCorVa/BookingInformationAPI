package es.viajeselcaminito.models.resort;

public class RoomResort {

    private String code;
    private String name;

    public RoomResort(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nRoomResort{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
