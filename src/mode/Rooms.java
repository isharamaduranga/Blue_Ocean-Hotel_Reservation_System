package mode;



public class Rooms {
    private String roomNo;
    private String roomType;
    private String cusNic;
    private String cusName;
    private String date;
    private String time;

    public Rooms() {

    }

    public Rooms(String roomNo, String roomType, String cusNic, String cusName, String date, String time) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.cusNic = cusNic;
        this.cusName = cusName;
        this.date = date;
        this.time = time;
    }



    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getCusNic() {
        return cusNic;
    }

    public void setCusNic(String cusNic) {
        this.cusNic = cusNic;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "roomNo='" + roomNo + '\'' +
                ", roomType='" + roomType + '\'' +
                ", cusNic=" + cusNic +
                ", cusName='" + cusName + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
