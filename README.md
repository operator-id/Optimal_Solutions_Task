# JavaProjects
 Interview task for OptimalSolutions 
 
 The program does the next steps:
- reads a CSV file and parses it
- the data is processed and organized into 2 lists
   -- one list with incomplete number of columns
    and another valid list
- a log file is created with statistics on records
- the invalid list gets written in a csv output file with a timestamp
- a table gets created in the embedded sqlite database
- the valid records are written in the table

The main method to RUN the application is in the Test class.

- Resources folder contains the CSV file that needs to be parsed.
- Output folder will contain the log and another CSV file with incomplete records.
- I have used the OpenCSV open source library to read/write CSV files. 
- For the embedded database I have used SQLITE, the database called "employeedb" is in the root folder.
- All the .jar files including JDBC for sqlite are located in the libraries folder.


 -- Sergiu Slanina
