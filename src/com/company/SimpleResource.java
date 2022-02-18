package com.company;

//A simple version of a resource from a patients file
public class SimpleResource {

    Patient patient; // need to figure out what to do if the resource is not a patient

    public SimpleResource()
    {
    }

    String resourceName = getResourceName();
    Boolean i = checkPatient(resourceName);


    public String getResourceName()
    {
        return "name" ;
    }

    // checks if the given resource is a patient
    public Boolean checkPatient(String type)
    {
        return type.equals("Patient"); // can be changed to only create objects contained in the resource (if)
    }

    public void createPatient()
    {
        if(checkPatient(this.resourceName))
        {
            this.patient = new Patient();
        }
    }
}