package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class FileReader {
    public void hedder() throws FileNotFoundException {
        File imdb = new File("Data/imdb-data.csv");

        Scanner sc = new Scanner(imdb);
        String data = sc.nextLine();
        String[] ordliste = data.split(";");
        StringBuilder sb = new StringBuilder();
        File sqlFile = new File("Data/imdb.sql");

        PrintStream ps = new PrintStream(new FileOutputStream(sqlFile, false));

        sb.append("CREATE TABLE imdb (\n");
        for (int i = 0; i < ordliste.length; i++) {
            if (i != ordliste.length-1){
                String coulomHeader = ordliste[i];
                sb.append(coulomHeader + " varchar(255), \n");
            }else{
                String coulomHeader = ordliste[i];
                sb.append(coulomHeader + " varchar(255) \n");
            }
            if (i == ordliste.length - 1) {
                sb.append(");");
            }
        }
        ps.println(sb);

    }
}
