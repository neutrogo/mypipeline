package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class PatientFile {
    ArrayList<Entry> entry = new ArrayList<>();

    //returns all entries of a given type
    public ArrayList<Entry> getEntryByName(String entryName) {
        ArrayList<Entry> entryOfType = new ArrayList<>();

        for (Entry value : entry) {
            if (value.resource.resourceType.equals(entryName)) {
                entryOfType.add(value);
            }
        }
        return entryOfType;
    }

    // sql query to create the "General Health" Table
    public String getGeneralHealth() {
        return "CREATE TABLE `Patient` ( " + "`entry` " + "int(11), " + "`familyName`" +
                "varchar(50) NOT NULL, " + "`givenName`" + "varchar(50) NOT NULL, " + "`prefix` " +
                "varchar(10), " + "PRIMARY KEY(`entry`) ) ";
    }

    public void setPatientStatements(PreparedStatement prep, Connection conn, String sql) throws SQLException {

        sql = "INSERT INTO Patient (`entry`,`familyName`,`givenName`,`prefix`) values (?,?,?,?)";

        String familyName = entry.get(0).resource.name.get(0).family;
        String givenName = entry.get(0).resource.name.get(0).given.get(0);
        String prefix = entry.get(0).resource.name.get(0).prefix.get(0);

        prep = conn.prepareStatement(sql);

        prep.setInt(1, 0);
        prep.setString(2, familyName);
        prep.setString(3, givenName);
        prep.setString(4, prefix);

        prep.executeUpdate();
    }

    // does not cover blood pressure, smoking and other non "single digit" values
    public void createObservation(PreparedStatement prep, Connection conn, String sql) throws SQLException {

        sql = "CREATE TABLE `General_Health` ( " + "`ID` int(11) AUTO_INCREMENT, " + "`measurement` " + "VARCHAR(100) NOT NULL, "
                + "`value` " + "double(200,1) NOT NULL, " + "`units` " + "varchar(50) NOT NULL, " +
                "PRIMARY KEY(`ID`) ) " ;

        prep = conn.prepareStatement(sql);

        prep.executeUpdate();

    }

    public void insertObservation(PreparedStatement prep, Connection conn, String sql) throws SQLException {
        for (Entry item : entry) {

            if (item.resource.resourceType.equals("Observation") && item.resource.code != null &&
                    item.resource.valueQuantity != null) {
                sql = "INSERT INTO General_Health (`measurement`,`value`,`units`) values (?,?,?)";

                String measurement = item.resource.code.coding.get(0).display;
                double value = item.resource.valueQuantity.value;
                String unit = item.resource.valueQuantity.unit;

                prep = conn.prepareStatement(sql);

                prep.setString(1, measurement);
                prep.setDouble(2, value);
                prep.setString(3, unit);

                prep.executeUpdate();

            }

        }
    }
}
