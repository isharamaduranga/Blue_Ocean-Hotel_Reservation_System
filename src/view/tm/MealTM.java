package view.tm;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class MealTM {
     private String roomNum;
     private String mealType;
     private String mealTime;
     private int portion;
     private double price;
     private Button btn;
     private CheckBox box;


    public MealTM() {

    }

    public MealTM(String roomNum, String mealType, String mealTime, int portion, double price, Button btn,CheckBox box ) {
        this.roomNum = roomNum;
        this.mealType = mealType;
        this.mealTime = mealTime;
        this.portion = portion;
        this.price = price;
        this.btn = btn;
        this.box = box;

    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getMealTime() {
        return mealTime;
    }

    public void setMealTime(String mealTime) {
        this.mealTime = mealTime;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    public CheckBox getBox() {
        return box;
    }

    public void setBox(CheckBox box) {
        this.box = box;
    }



    @Override
    public String toString() {
        return "MealTM{" +
                "roomNum='" + roomNum + '\'' +
                ", mealType='" + mealType + '\'' +
                ", mealTime='" + mealTime + '\'' +
                ", portion=" + portion +
                ", price=" + price +
                ", btn=" + btn +
                ", box=" + box +
                '}';
    }
}
