## My Pipeline

This Project aims to offer an MVP of a pipeline that parses JSON files of the FHIR standard. The type of data required is input into the command line by the user, storing the given information as a .sql Database.

# inputting your personal mySQL details

under Database.class you will find the details to log in to your mySQL. These need to be changed if you have a password set or a user other than root that you want to use. by default, the user is set to "root" and the password is left blank.

(This is due to current issues experienced with Docker, Apologies for the inconvenience)

# Running the Program

Once compilled, You will be given the choice as to which type of dataset you want to generate. Currently, only "General Health" will work. The second prompt will ask you for the given JSON file to parse. Sample files are found in the /data directory, and their names can be used to try the pipeline.

An example:

What dataset would you like to create? General Health Data or (further options)?

> General Health

Which file would you like to use?
(Please indicate a JSON File of the FHIR format in the data folder), eg. XYZ.json)

> Aaron697_Dickens475_8c95253e-8ee8-9ae8-6d40-021d702dc78e.json


## Reasoning

Due to the analytics team seemingly struggling with JSON files, the assumption was made that a simpler, easy to approach solution was required for the team. While SQL knowledge is expected for this program, the generation of a database of various "packages" make the process of dealing with FHIR standard files easier. This is demonstrated by the generation of a "General Health" bundle that details a patients basic information and some readings such as their Height and Weight in the form of two tables. In this case, the team may use this General Health package to assess the overall Health of certain patients.

