package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main1 {

    public static void main(String[] args) {

        try(var stream = new FileInputStream("text.txt"))
        {
            try(var reader = new InputStreamReader(stream))
            {
                var data = new char[1024];

                reader.read(data);

                System.out.println(data);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
