package com.company;

import java.util.ArrayList;

public class resource
{
    String resourceType;
    ArrayList<name> name = new ArrayList<>();
    ArrayList<telecom> telecom = new ArrayList<>();
    String gender;
    String birthDate;


    //deceasedate time necessary

    //ArrayList<address> address = new ArrayList<>();
    maritalStatus maritalStatus;
    ArrayList<communication> communication = new ArrayList<>();

    // General health package
    code code;
    valueQuantity valueQuantity; // if not this then its component for blood pressure
    ArrayList<component> component = new ArrayList<>();
}
