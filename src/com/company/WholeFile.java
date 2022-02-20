package com.company;

import java.util.ArrayList;

public class WholeFile {
    ArrayList<entry> entry = new ArrayList<>();

    //returns all entries of a given type
    public ArrayList<entry> getEntryByName(String entryName)
    {
        ArrayList<entry> entryOfType = new ArrayList<>();

        for (com.company.entry value : entry) {
            if (value.resource.resourceType.equals(entryName)) {
                entryOfType.add(value);
            }
        }
        return entryOfType;
    }

    public String getGeneralHealth()
    {
        String query = "DROP TABLE IF EXISTS 'General Health';" +"CREATE DATABASE General Health; " + "USE General Health;" + "CREATE TABLE 'Patient Health' ("
                + "(" + "'entry'" + "int(11)" + "'family name'" + "varchar(50) NOT NULL," + "'given name'" + "varchar(50) NOT NULL," +
                "'prefix' " + "varchar(10)," + "'Communication'" + "varchar(50)," + "'value' " + "varchar(20)," +
                "'Type'" + "varchar(50)," + "'Gender'" + "varchar(20)," + "'Birth Date'" + "varchar(20) NOT NULL," +
                "'Marital Status'" + "varchar(5) NOT NULL," + "'Communication'" + "varchar(10)," + "'Measured'" +
                "'varchar(20) NOT NULL," + "'Quantity'" + "float(10) NOT NULL," + "'Metric'" + "varchar(15) NOT NULL," +
                "'Smoker'" + "varchar(20) NOT NULL," + "PRIMARY KEY('entry')";

        // check that float and smoker functions

        for(int i = 0; i < entry.size(); i++)
        {
            entry.get(i).resource.;
        }
    }
}
