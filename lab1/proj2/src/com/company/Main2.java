package com.company;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        System.out.println("Co wpisac do pliku?");

        var input = System.console().readLine();

//        var file = new File("output.txt");
//
//        file.createNewFile();

        try (var myWriter = new FileWriter("filename.txt"))
        {
            myWriter.write(input);
        }

        System.out.println("wpisano");
    }
}
