package lesson14_extended.university.real_estates;

public class OwnHousing implements StudentAddressable {

    private String address;

    public OwnHousing(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String getAddressString() {
        return address;
    }

    @Override
    public Room getRoom() {
        return null;
    }

    @Override
    public Dormitory getDormitory() {
        return null;
    }
}
