package mode;

public class cleaner {
    private String roomNum;
    private String time;

    public cleaner() {
    }

    public cleaner(String roomNum, String time) {
        this.roomNum = roomNum;
        this.time = time;
    }

    public cleaner(String time) {
        this.time=time;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "cleaner{" +
                "roomNum='" + roomNum + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
