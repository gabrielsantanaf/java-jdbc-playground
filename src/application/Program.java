package application;

import application.model.Seller;
import application.use_cases.Escrita;
import application.use_cases.Leitura;

import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {


        Leitura leitura = new Leitura();
        leitura.get("select * from department");

        Escrita escrita = new Escrita();
        Seller seller = new Seller(
                "Carl Purple",
                "carl@gmail.com",
                "22/04/1985",
                3000.0,
                4
        );

        escrita.insertSeller(seller);


    }
}