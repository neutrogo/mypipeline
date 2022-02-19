package com.company;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        JSONParser parser = new JSONParser();
        Gson gson = new Gson();

        Reader reader = new FileReader(parser.getFilePath());

            WholeFile testsimple = gson.fromJson(reader, WholeFile.class);


            //consider eliminating all empty values from entry objects

    }
}
