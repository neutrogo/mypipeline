package com.company;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //System.out.println("Hello World!");
        JSONParser parser = new JSONParser();
        Gson gson = new Gson();

        Reader reader = new FileReader(parser.getFilePath());

        //int cnt = 0;

        //while (cnt != 2)
        //{
            WholeFile testsimple = gson.fromJson(reader, WholeFile.class);
            //cnt++;
        //}

        //System.out.println(testsimple);
    }
}
