package view.tm;

import javafx.scene.control.Button;

public class IncomeTM {

    private String month;
    private double roomCgh;
    private double mealCgh;
    private double serviceCgh;
    private Button btn;
    private double monthAll;
    private double yearAll;

    public IncomeTM() {
    }

    public IncomeTM(String month, double roomCgh, double mealCgh, double serviceCgh, Button btn, double monthAll, double yearAll) {
        this.month = month;
        this.roomCgh = roomCgh;
        this.mealCgh = mealCgh;
        this.serviceCgh = serviceCgh;
        this.btn = btn;
        this.monthAll = monthAll;
        this.yearAll = yearAll;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getRoomCgh() {
        return roomCgh;
    }

    public void setRoomCgh(double roomCgh) {
        this.roomCgh = roomCgh;
    }

    public double getMealCgh() {
        return mealCgh;
    }

    public void setMealCgh(double mealCgh) {
        this.mealCgh = mealCgh;
    }

    public double getServiceCgh() {
        return serviceCgh;
    }

    public void setServiceCgh(double serviceCgh) {
        this.serviceCgh = serviceCgh;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    public double getMonthAll() {
        return monthAll;
    }

    public void setMonthAll(double monthAll) {
        this.monthAll = monthAll;
    }

    public double getYearAll() {
        return yearAll;
    }

    public void setYearAll(double yearAll) {
        this.yearAll = yearAll;
    }

    @Override
    public String toString() {
        return "IncomeTM{" +
                "month='" + month + '\'' +
                ", roomCgh=" + roomCgh +
                ", mealCgh=" + mealCgh +
                ", serviceCgh=" + serviceCgh +
                ", btn=" + btn +
                ", monthAll=" + monthAll +
                ", yearAll=" + yearAll +
                '}';
    }
}
