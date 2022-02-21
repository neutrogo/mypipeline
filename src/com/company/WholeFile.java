package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        // full table, partitioning by category/observation may be better
        String query = "DROP DATABASE IF EXISTS 'General Health';" +"CREATE DATABASE General Health; " + "USE General Health;" + "CREATE TABLE 'Patient Health' ("
                + "(" + "'entry'" + "int(11)" + "'family name'" + "varchar(50) NOT NULL," + "'given name'" + "varchar(50) NOT NULL," +
                "'prefix' " + "varchar(10)," + "'Communication'" + "varchar(50)," + "'value' " + "varchar(20)," +
                "'Type'" + "varchar(50)," + "'Gender'" + "varchar(20)," + "'Birth Date'" + "varchar(20) NOT NULL," +
                "'Marital Status'" + "varchar(5) NOT NULL," + "'Communication'" + "varchar(10)," + "'Measured'" +
                "'varchar(20) NOT NULL," + "'Quantity'" + "float(10) NOT NULL," + "'Metric'" + "varchar(15) NOT NULL," +
                "'Smoker'" + "varchar(20) NOT NULL," + "PRIMARY KEY('entry')";

        String testquery = /*"DROP DATABASE IF EXISTS 'General Health'; "*/ /*+ "CREATE DATABASE `GeneralHealth`; "
                +*/ /*"USE `General Health`; "*/ /*+ "DROP TABLE IF EXISTS `Patient Health`; "+*/ "CREATE TABLE `PatientHealth` ( " + "`entry` " + "int(11), "
                + "`familyName`" + "varchar(50) NOT NULL, " + "`givenName`" + "varchar(50) NOT NULL, " +
                "`prefix` " + "varchar(10), " + "PRIMARY KEY(`entry`) ) " ;



        // check that float and smoker functions

/*        for(int i = 0; i < entry.size(); i++)
        {*/
        int i = 0;

            /*String familyName = entry.get(i).resource.name.get(0).family;
            String givenName = entry.get(i).resource.name.get(0).given.get(0);
            String prefix = entry.get(i).resource.name.get(0).prefix.get(0);
            String fullName = givenName + familyName;
*/
            //String tableQuery = "INSERT INTO PatientHealth (`entry`,`familyName`,`givenName`,`prefix`) values (?,?,?,?)";

                    /*"(" + i + ",'" + familyName + "','" + givenName + "','" + prefix + "');"*/


            /*String tableQuery = "CREATE TABLE '" + fullName + "' (" + "'entry'" + "int(11)" + "'family name'" +
                    "varchar(50) NOT NULL," + "'given name'" + "varchar(50) NOT NULL," + "'prefix' " + "varchar(10)," +
                    "PRIMARY KEY ('entry') )" + "insert into '" + fullName + "' (" + "'" + i + "','" + familyName +
                    "','" + givenName + "','" + "','" + prefix + ") values";*/

        return testquery;
/*        }
        return " "; // change this*/
    }

    public void setPatientStatements(PreparedStatement prep, Connection conn, String sql) throws SQLException {

        sql = "INSERT INTO PatientHealth (`entry`,`familyName`,`givenName`,`prefix`) values (?,?,?,?)";

        String familyName = entry.get(0).resource.name.get(0).family;
        String givenName = entry.get(0).resource.name.get(0).given.get(0);
        String prefix = entry.get(0).resource.name.get(0).prefix.get(0);
        String fullName = givenName + familyName;

        prep = conn.prepareStatement(sql);

        prep.setInt(1, 0);
        prep.setString(2, familyName);
        prep.setString(3, givenName);
        prep.setString(4, prefix);

        prep.executeUpdate();
    }

    // does NOT cover blood pressure or smoking
    public void createObservation(PreparedStatement prep, Connection conn, String sql) throws SQLException {

        sql = "CREATE TABLE `General_Health` ( " + "`ID` int(11) AUTO_INCREMENT, " + "`measurement` " + "VARCHAR(100) NOT NULL, "
                + "`value` " + "double(200,1) NOT NULL, " + "`units` " + "varchar(50) NOT NULL, " +
                "PRIMARY KEY(`ID`) ) " ;

        prep = conn.prepareStatement(sql);

        prep.executeUpdate();

    }

    public void insertObservation(PreparedStatement prep, Connection conn, String sql) throws SQLException {
        for(int i = 0; i < entry.size(); i++)
        {

            if(entry.get(i).resource.resourceType.equals("Observation") && entry.get(i).resource.code != null &&
               entry.get(i).resource.valueQuantity != null)
                    //entry.get(i).resource.code.coding.get(0).display.equals("Body Height") ||
                    //entry.get(i).resource.code.coding.get(0).display.equals("Body Weight") ||
                    //entry.get(i).resource.code.coding.get(0).display.equals("Body Mass Index") ||
                    //entry.get(i).resource.code.coding.get(0).display.equals("Heart rate"))
            {
                sql = "INSERT INTO General_Health (`measurement`,`value`,`units`) values (?,?,?)";

                String measurement = entry.get(i).resource.code.coding.get(0).display;
                double value = entry.get(i).resource.valueQuantity.value;
                String unit = entry.get(i).resource.valueQuantity.unit;

                prep = conn.prepareStatement(sql);

                prep.setString(1, measurement);
                prep.setDouble(2, value);
                prep.setString(3, unit);

                prep.executeUpdate();

            }

        }
    }
}
