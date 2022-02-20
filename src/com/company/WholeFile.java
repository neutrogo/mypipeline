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
        String query = "CREATE DATABASE General Health; " + "USE General Health;" + "CREATE TABLE 'Patient Health'"
                + "{" + "'family name' " + "varchar(50) NOT NULL," + "'given name' " + "varchar(50) NOT NULL," +
                "'prefix' " + "varchar(10)," + "'telecom' " + "varchar(20)," + "";
        for(int i = 0; i < entry.size(); i++)
        {
            entry.get(i).resource.;
        }
    }
}
