package com.company;

import com.google.gson.Gson;

import java.io.*;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws IOException {

        //JSON Parser Objects
        Filechooser chooser = new Filechooser();
        Gson gson = new Gson();

        //Objects to read the users CLI input
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What dataset would you like to create? General Health Data or (further options)?");
        String userInput = bReader.readLine();
        System.out.println("Which file would you like to use?");
        System.out.println("(Please indicate a JSON File of the FHIR format in the data folder), eg. XYZ.json)");
        chooser.patientFile = bReader.readLine();

        Reader reader = new FileReader(chooser.getFilePath());

        PatientFile patientFile = gson.fromJson(reader, PatientFile.class);

        if(userInput.equalsIgnoreCase("general health")) {
            String sql = patientFile.getGeneralHealth();

            // Turn FHIR file into an SQL Database
            try (Connection conn = DriverManager.getConnection(Database.DB_URL, Database.USER, Database.PASS);
                 PreparedStatement preparedStatement = conn.prepareStatement(sql)

            ) {
                preparedStatement.executeUpdate("DROP DATABASE IF EXISTS `Patient_Data`");
                preparedStatement.executeUpdate("CREATE DATABASE `Patient_Data`");
                conn.setCatalog("`Patient_Data`");
                System.out.println("Database connected successfully!");
                System.out.println("\nConstructing your Database...");
                preparedStatement.executeUpdate("DROP TABLE IF EXISTS `Patient`");
                preparedStatement.executeUpdate("DROP TABLE IF EXISTS `General_Health`");
                preparedStatement.executeUpdate(sql);
                patientFile.setPatientStatements(preparedStatement, conn, sql);
                patientFile.createObservation(preparedStatement,conn, sql);
                patientFile.insertObservation(preparedStatement,conn,sql);
                System.out.println("Finished!");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
