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
}
