package mode;

public class Customer {
    private String name;
    private String id;
    private String tpNum;
    private String email;
    private String address;
    private String roomNum;

    public Customer() {
    }

    public Customer(String name, String id, String tpNum, String email, String address, String roomNum) {
        this.name = name;
        this.id = id;
        this.tpNum = tpNum;
        this.email = email;
        this.address = address;
        this.roomNum = roomNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTpNum() {
        return tpNum;
    }

    public void setTpNum(String tpNum) {
        this.tpNum = tpNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", tpNum='" + tpNum + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", roomNum='" + roomNum + '\'' +
                '}';
    }
}
