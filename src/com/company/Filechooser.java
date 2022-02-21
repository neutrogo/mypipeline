package com.company;

public class Filechooser {

    String patientFile = "";
    String filePath = "data/";

    public Filechooser()
    {
    }

    public String getFilePath()
    {

        return filePath + patientFile;
    }
}
