package com.company;

import java.util.ArrayList;

public class Resource {
    String resourceType;
    ArrayList<Name> name = new ArrayList<>();
    ArrayList<Telecom> telecom = new ArrayList<>();
    String gender;
    String birthDate;

    //ArrayList<address> address = new ArrayList<>();
    MaritalStatus maritalStatus;
    ArrayList<Communication> communication = new ArrayList<>();

    Code code;
    ValueQuantity valueQuantity;
    ArrayList<Component> component = new ArrayList<>();
    ValueCodeableConcept valueCodeableConcept;
}
