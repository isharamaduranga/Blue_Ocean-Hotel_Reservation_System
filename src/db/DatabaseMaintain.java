package db;

import mode.cleaner;

import java.util.ArrayList;

public class DatabaseMaintain {

    public static ArrayList<cleaner> cleanTable =new ArrayList<cleaner>();

    static {

        cleanTable.add(new cleaner( "ROOM-01","4.30 PM"));
        cleanTable.add(new cleaner( "ROOM-02","5.50 AM"));
        cleanTable.add(new cleaner( "ROOM-03","6.46 PM"));
        cleanTable.add(new cleaner( "ROOM-04","7.30 PM"));
        cleanTable.add(new cleaner( "ROOM-05","8.00 AM"));
        cleanTable.add(new cleaner( "ROOM-06","9.00 PM"));
        cleanTable.add(new cleaner( "ROOM-07","10.00 AM"));
        cleanTable.add(new cleaner( "ROOM-08","11.00 PM"));
        cleanTable.add(new cleaner( "ROOM-09","06.00 AM"));
        cleanTable.add(new cleaner( "ROOM-10","07.15 PM"));
        cleanTable.add(new cleaner( "ROOM-11","08.00 AM"));
        cleanTable.add(new cleaner( "ROOM-12","12.30 PM"));
        cleanTable.add(new cleaner( "ROOM-13","01.00 PM"));
        cleanTable.add(new cleaner( "ROOM-14","06.12 PM"));
        cleanTable.add(new cleaner( "ROOM-15","03.20 PM"));
        cleanTable.add(new cleaner( "ROOM-16","02.00 PM"));
        cleanTable.add(new cleaner( "ROOM-17","07.15 AM"));
        cleanTable.add(new cleaner( "ROOM-18","05.00 PM"));
        cleanTable.add(new cleaner( "ROOM-19","06.00 AM"));
        cleanTable.add(new cleaner( "ROOM-20","08.15 PM"));
        cleanTable.add(new cleaner( "ROOM-21","07.00 AM"));
        cleanTable.add(new cleaner( "ROOM-22","12.00 PM"));
        cleanTable.add(new cleaner( "ROOM-23","11.45 AM"));
        cleanTable.add(new cleaner( "ROOM-24","09.00 PM"));
        cleanTable.add(new cleaner( "ROOM-25","08.30 AM"));

    }

}
