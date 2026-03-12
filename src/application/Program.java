package application;

import db.DB;
import domain.entity.Seller;
import repositories.Read;
import repositories.Write;


public class Program {
    public static void main(String[] args) {


        Read read = new Read(DB.getConnection());
        read.get("select * from department");

        Write write = new Write(DB.getConnection());
        Seller seller = new Seller(
                "João",
                "joão@gmail.com",
                "22/04/1985",
                3000.0,
                4
        );

        write.insertSeller(seller);


    }
}