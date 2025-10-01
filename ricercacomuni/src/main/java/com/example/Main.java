package com.example;
import com.opencsv.CSVReader;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
      try {
            CSVReader reader = new CSVReader(new FileReader("listacomuni.csv"));
            String[] riga;
            Scanner scan = new Scanner(System.in);
            String ISTAT = scan.nextLine();
            scan.close();
            while((riga = reader.readNext()) != null) {
                String comune = "";
                String[] split = riga[0].split(";");
                if (split[0].equals(ISTAT)) {
                    for (int i = 0; i < 9; i++) {
                        comune += split[i] + ";";
                    }
                    System.out.println(comune);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }   
}