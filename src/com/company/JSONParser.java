package com.company;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.Scanner;

public class JSONParser {

    Gson gson = new Gson();
    String patientFile = "input patient file here";
    String filePath = ".." + File.pathSeparator + ".." + File.pathSeparator + "data" + patientFile;
    File patientData = new File(filePath); //file seperator used for system agnostic utilisation
    Scanner scan = new Scanner(patientData);


    public JSONParser() throws FileNotFoundException {
    }
}
