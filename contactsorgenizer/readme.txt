
INTRODUCTION
------------
This application stores contacts' data, given by the user.
Each contact includes 3 members; name, email and mobile number.
The user can add a new contact, remove an exist one, update a contact, query and display it,
display all contacts and save the changes on your local machine (where the application executed from).

REQUIREMENTS
------------
JDK 1.8 installed on your machine.


CONTENTS
--------
This application contains the following:

    /readme.txt - this file
    /pom.xml - contains information about the project and configuration details used by Maven to build the project.
	/src/main/resources/meta-inf/manifest.mf - part of the /pom.xml definitions
    /src - contains all application classes:
	- /src/main/java/Main
	- /src/main/java/ContactsOrgenizer
	- /src/main/java/ContactsManager
	- /src/main/java/Contact

* you may find the entire source code at: https://github.com/efi1/java_projects

RUNNING THE APPLICATION
-----------------------
1. Copy the jar artifact - contactsorgenizer-1.0-SNAPSHOT.jar - to your machine.
2. Run it, by using the following command:
    java -jar contactsorgenizer-1.0-SNAPSHOT.jar


USING THE APPLICATION:
----------------------
When running this application, a menu is displayed:

 1. Add a new contact
 2. Remove an exist contact
 3. Update an exist contact
 4. Display contact by name
 5. Display all contacts
 6. Save contacts to disk
 7. Read contacts from disk
 8. Exit

 The user should select one of the options (1-8).
 After selecting one of the option, some more inputs are required from the user (for some of the above options);
 - Options (1,3), will ask the user to supply the contact elements (name, mobile and email) - each on a time.
 - Options (2,4), will ask the contact's name to be deleted (2) or to be displayed (4).
 - Option (6,7) saves the data (6) or read it (7) from your local machine, where it is saved.
 - Option (8) save the contact's changes, which the user made and exit the application.
 * reading the data from your local machine is done automatically. by starting the application.
   If no precede data was saved to your local machine (i.e. if you run your application on your
   local machine for the first time), no data is to be read.

