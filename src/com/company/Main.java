package com.company;

import com.google.gson.Gson;

import java.io.*;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws IOException {

        //JSON Parser Objects
        JSONParser parser = new JSONParser();
        Gson gson = new Gson();

        //Objects to read the users CLI input
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What dataset would you like to create? General Health Data or (further options)?");
        String userInput = bReader.readLine();

        Reader reader = new FileReader(parser.getFilePath());

        WholeFile testsimple = gson.fromJson(reader, WholeFile.class);


        if(userInput.toLowerCase().equals("general health")) {
            String sql = testsimple.getGeneralHealth();

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
                testsimple.setPatientStatements(preparedStatement, conn, sql);
                testsimple.createObservation(preparedStatement,conn, sql);
                testsimple.insertObservation(preparedStatement,conn,sql);
                System.out.println("Finished!");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
