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

        System.out.println("What dataset would you like to create? General Health or xxxxx?");
        String userInput = bReader.readLine();


        Reader reader = new FileReader(parser.getFilePath());

        WholeFile testsimple = gson.fromJson(reader, WholeFile.class);


        if(userInput.toLowerCase().equals("general health")) {
            String sql = testsimple.getGeneralHealth();

            try (Connection conn = DriverManager.getConnection(Database.DB_URL, Database.USER, Database.PASS);
                 //Statement stmt = conn.createStatement();
                 PreparedStatement preparedStatement = conn.prepareStatement(sql)

            ) {
                //stmt.executeUpdate(("CREATE DATABASE `General Health`"));
                conn.setCatalog("`General Health`");
                System.out.println("Database connected successfully...");
                preparedStatement.executeUpdate(sql);
                testsimple.setPatientStatements(preparedStatement, conn, sql);
                //preparedStatement.executeUpdate();
                //stmt.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
            //consider eliminating all empty values from entry objects

    }
}
