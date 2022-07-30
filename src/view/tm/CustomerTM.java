package view.tm;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class CustomerTM {

     private String name;
     private String id;
     private String tpNum;
     private String email;
     private String address;
     private String roomNum;
     private ComboBox availableBox;
     private ComboBox mealBox;
     private Button btn;

    public CustomerTM() {

    }

    public CustomerTM(String name, String id, String tpNum, String email, String address, String roomNum, ComboBox<String> availableBox, ComboBox<String> mealBox, Button btn) {
        this.name = name;
        this.id = id;
        this.tpNum = tpNum;
        this.email = email;
        this.address = address;
        this.roomNum = roomNum;
        this.availableBox = availableBox;
        this.mealBox = mealBox;
        this.btn = btn;
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

    public ComboBox<String> getAvailableBox() {
        return availableBox;
    }

    public void setAvailableBox(ComboBox<String> availableBox) {
        this.availableBox = availableBox;
    }

    public ComboBox<String> getMealBox() {
        return mealBox;
    }

    public void setMealBox(ComboBox<String> mealBox) {
        this.mealBox = mealBox;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "CustomerTM{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", tpNum='" + tpNum + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", roomNum='" + roomNum + '\'' +
                ", availableBox=" + availableBox +
                ", mealBox=" + mealBox +
                ", btn=" + btn +
                '}';
    }
}
