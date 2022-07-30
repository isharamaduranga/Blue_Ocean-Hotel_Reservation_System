package db;

import mode.Meals;

import java.util.ArrayList;

public class DatabaseMeal {

    public static ArrayList<Meals> mealsTable = new ArrayList<Meals>();

    static {
        mealsTable.add(
                new Meals("R00M-001","CHINESE","DINER",03,2500.00)
        );
        mealsTable.add(
                new Meals("ROOM-002","FRENSH","LUNCH,DINNER",04,3500.00)
        );
        mealsTable.add(
                new Meals("ROOM-003","LOCAL","BREAKFAST",05,6500.00)
        );
        mealsTable.add(
                new Meals("ROOM-004","CHINESE","DINER",01,1500.00)
        );

    }

}
