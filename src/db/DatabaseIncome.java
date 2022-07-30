package db;

import mode.Income;

import java.util.ArrayList;

public class DatabaseIncome {
    public static ArrayList<Income> incomeTable= new ArrayList<Income>();


    static {
        incomeTable.add(
                new Income("JANUARY",50000.00,80000.00,45000.00,0.00,0.00)
        );
        incomeTable.add(
                new Income("FEBRUARY",40000.00,30000.00,45000.00,0.00,0.00)
        );
        incomeTable.add(
                new Income("MARCH",60000.00,70000.00,45000.00,0.00,0.00)
        );
        incomeTable.add(
                new Income("APRIL",30000.00,80000.00,45000.00,0.00,0.00)
        );
        incomeTable.add(
                new Income("MAY",20000.00,90000.00,45000.00,0.00,0.00)
        );
        incomeTable.add(
                new Income("JUNE",60000.00,70000.00,45000.00,0.00,0.00)
        );
        incomeTable.add(
                new Income("JULY",50000.00,80000.00,45000.00,0.00,0.00)
        );
        incomeTable.add(
                new Income("AUGUST",40000.00,30000.00,45000.00,0.00,0.00)
        );
        incomeTable.add(
                new Income("SEPTEMBER",60000.00,70000.00,45000.00,0.00,0.00)
        );
        incomeTable.add(
                new Income("OCTOBER",30000.00,80000.00,45000.00,0.00,0.00)
        );
        incomeTable.add(
                new Income("NOVEMBER",20000.00,90000.00,45000.00,0.00,0.00)
        );
        incomeTable.add(
                new Income("DECEMBER",60000.00,70000.00,45000.00,0.00,0.00)
        );



    }
}
