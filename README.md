# test_for_junior
Java 1.8 application containing the Result findNumber (Integer number) method returning a Result object.    
The method searches the given number in 20 large text files of different compositions (each more than 1 GB).    
Files consist only of numbers, which are separated by a comma.  
The results save in the database.

## Database creation script:  
create table dbwithsearchresult (    
id serial,    
    code varchar(50),    
    number int,    
    filenames varchar(100),    
    error varchar(100),    
    primary key (id));    

Implemented a method for generating 20 text files for searching.
