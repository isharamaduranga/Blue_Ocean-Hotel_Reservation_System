package db;

import mode.Customer;

import java.util.ArrayList;

public class DatabaseReservation {

    public static ArrayList<Customer> customerTable = new ArrayList<Customer>();

    static {
        customerTable.add(
                new Customer("MADHRA PRADEEP","971236454V","0776343456","madura@gmail.com","No/05 COLOMBO","ROOM-01")
        );
        customerTable.add(
                new Customer("SUGATH VISAL","912346454V","0776667546","sugath@gmail.com","No/04 PANADURA","ROOM-02")
        );
        customerTable.add(
                new Customer("KALANA PERERA","954321454V","0776127575","kalana@gmail.com","No/03 NEGOMBO","ROOM-03")
        );
        customerTable.add(
                new Customer("NIMAL SIRIPALA","876546454V","0773554562","nimal@gmail.com","No/02 GAMPAHA","ROOM-04")
        );
        customerTable.add(
                new Customer("CHANDANA SILVA","834536454V","0714562310","chandana@gmail.com","No/01 COLOMBO","ROOM-05")
        );
        customerTable.add(
                new Customer("SUNIL PERERA","789656454V","0701234567","sunil@gmail.com","No/08 COLOMBO","ROOM-06")
        );
        customerTable.add(
                new Customer("ASHOKA IMRAN","954321454V","0776999575","ashoka@gmail.com","No/07 NEGOMBO","ROOM-07")
        );
        customerTable.add(
                new Customer("SACHITH HARSHANA","876546454V","0745654562","sachith@gmail.com","No/04 GAMPAHA","ROOM-08")
        );
        customerTable.add(
                new Customer("ISHAN ANURADA","834536454V","0712222310","ishan@gmail.com","No/06 COLOMBO","ROOM-09")
        );
        customerTable.add(
                new Customer("PASINDU DILSHAN","789656454V","0707895567","pasindu@gmail.com","No/07 COLOMBO","ROOM-10")
        );

    }

    }





