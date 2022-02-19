package com.company;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class JSONParser {

    String patientFile = "Aaron697_Dickens475_8c95253e-8ee8-9ae8-6d40-021d702dc78e.json";
    String filePath = /*".." + File.separator + ".." + File.separator + ".." + File.separator + "data" + File.separator*/ "data/"+ patientFile;

    public JSONParser() throws FileNotFoundException
    {
    }
/*    Gson gson = new Gson();
    ArrayList<String> JSONString = new ArrayList<>();
    String patientFile = "Aaron697_Dickens475_8c95253e-8ee8-9ae8-6d40-021d702dc78e.json";
    String filePath = ".." + File.pathSeparator + ".." + File.pathSeparator + "data" + File.pathSeparator + patientFile;
    File patientData = new File(filePath); //file seperator used for system agnostic utilisation
    Scanner scan = new Scanner(patientData);

    //String Json = gson.fromJson(readJson(),)



    public JSONParser() throws FileNotFoundException {
    }*/

    Gson gson = new Gson();

    Reader rd = new FileReader(filePath);


    public String getFilePath()
    {
        return this.filePath;
    }
}
