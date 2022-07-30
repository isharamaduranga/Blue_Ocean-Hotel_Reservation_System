package mode;

public class Meals {
    private String roomNum;
    private String mealType;
    private String mealTime;
    private int portion;
    private double price;


    public Meals() {

    }

    public Meals(String roomNum, String mealType, String mealTime, int portion, double price) {
        this.roomNum = roomNum;
        this.mealType = mealType;
        this.mealTime = mealTime;
        this.portion = portion;
        this.price = price;
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

    @Override
    public String toString() {
        return "Meals{" +
                "roomNum='" + roomNum + '\'' +
                ", mealType='" + mealType + '\'' +
                ", mealTime='" + mealTime + '\'' +
                ", portion=" + portion +
                ", price=" + price +
                '}';
    }
}
