# test_for_junior
Java 1.8 application containing the Result findNumber (Integer number) method,  
which searches the given number in 20 large text files of different compositions (each more than 1 GB).  
Files consist only of numbers, which are separated by a comma.  
The result writes to the database, the method returns a Result object.

## Database creation script:  
create table dbwithsearchresult (  
id serial,  
    code varchar(50),  
    number int,  
    filenames varchar(100),  
    error varchar(100),  
    primary key (id));  

#### Implemented a method for generating 20 text files for searching.

## Test item requirements:
The Result object must have the following structure:  
* code - program execution code (see codes below)  
* fileNames - the names of the files where the number was found  
* error - a description of the error, if any. 

The table structure should be as follows:  
* ID - NUMBER (*, 0) - PK, auto-increment,  
* CODE - VARCHAR2 (50 BYTE) - program executing code (see codes below),  
* NUMBER - NUMBER (*, 0) - given number,  
* FILENAMES - VARCHAR2 (100 BYTE) - the names of the files where the number was found, 
* ERROR - VARCHAR2 (100 BYTE) - description of the error, in case it occurred.  

Program execution codes need to be saved in the CODE column and the code field of the Result object:  
* 00.Result.OK - The number was found,  
* 01.Result.NotFound - The number was not found,  
* 02.Result.Error - An error occurred frow the program executing.
