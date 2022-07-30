package view.tm;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class CleanerTM {
    private String roomNum;
    private String time;
    private ComboBox availability;
    private CheckBox cleanStatus;


    public CleanerTM() {
    }

    public CleanerTM(String roomNum, String time, ComboBox availability, CheckBox cleanStatus) {
        this.roomNum = roomNum;
        this.time = time;
        this.availability = availability;
        this.cleanStatus = cleanStatus;
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

    public ComboBox<String> getAvailability() {
        return availability;
    }

    public void setAvailability(ComboBox<String> availability) {
        this.availability = availability;
    }

    public CheckBox getCleanStatus() {
        return cleanStatus;
    }

    public void setCleanStatus(CheckBox cleanStatus) {
        this.cleanStatus = cleanStatus;
    }

    @Override
    public String toString() {
        return "CleanerTM{" +
                "roomNum='" + roomNum + '\'' +
                ", time='" + time + '\'' +
                ", availability=" + availability +
                ", cleanStatus=" + cleanStatus +
                '}';
    }
}
