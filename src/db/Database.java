package db;

import mode.Rooms;

import java.util.ArrayList;

public class Database {
    public static ArrayList<Rooms> roomsTable=new ArrayList<Rooms>();


    static {
        roomsTable.add(
          new Rooms("ROOM-01","SINGLE","970063439V","Ishara Maduranga","01/10/2020,","3.00 PM")
        );
        roomsTable.add(
                new Rooms("ROOM-02","TRIPLE","660634139V","Damith Dilshan","06/10/2021,","2.00 PM")
        );
        roomsTable.add(
                new Rooms("ROOM-03","DOUBLE","915663439V","Ravindu Gayan","30/01/2022,","4.00 AM")
        );
        roomsTable.add(
                new Rooms("ROOM-04","SINGLE","200063439V","Ishan Anuradha","21/05/2021,","6.00 PM")
        );
        roomsTable.add(
                new Rooms("ROOM-05","SINGLE","595563439V","Wishal Perera","11/02/2020,","9.00 AM")
        );
    }

}
