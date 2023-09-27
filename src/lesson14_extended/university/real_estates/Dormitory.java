package lesson14_extended.university.real_estates;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class Dormitory {

    private final HashSet<Room> roomList;
    private String name;
    private String address;

    {
        roomList = new HashSet<>();
    }

    public Dormitory(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addRooms(Room... rooms) {
        roomList.addAll(Arrays.asList(rooms));
    }

    public void removeRooms(Room... rooms) {
        Arrays.asList(rooms).forEach(roomList::remove);
    }

    public Room getFirstNonFilledRoom() {
        return roomList.stream().filter(room -> room.getStudentsList().size() < room.getMaxInhabitants()).findFirst().orElse(null);
    }

    public boolean roomContains(Room room) {
        return roomList.contains(room);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dormitory dormitory = (Dormitory) o;
        return Objects.equals(name, dormitory.name) && Objects.equals(address, dormitory.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

    @Override
    public String toString() {
        return "Общежитие (" + "название: '" + name + ", адрес: " + address + ")";
    }
}
