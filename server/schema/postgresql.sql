-- Create Schema 
CREATE SCHEMA accountschema; 

-- Create Table Address
CREATE TABLE accountschema.Address ( 
addressId int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1),
streetAddress1 varchar(50) NOT NULL, 
streetAddress2 varchar(50) DEFAULT NULL, 
city varchar(50) NOT NULL, 
zipCode varchar(50) NOT NULL, 
countryCd varchar(50) NOT NULL, 
stateCd varchar(50) NOT NULL, 
createDTM date DEFAULT NULL, 
createUserId varchar(50) DEFAULT NULL, 
lastUpdtDTM date DEFAULT NULL, 
lastUpdtUserId varchar(50) DEFAULT NULL, 
PRIMARY KEY (addressId)); 

-- Create Table Customer
CREATE TABLE accountschema.Customer ( 
cusId int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1),
cusName varchar(200) NOT NULL, 
addressId int NOT NULL, 
CONSTRAINT addressId_fkey
FOREIGN KEY (addressId)
REFERENCES accountschema.Address(addressId),
contactNo varchar(50) DEFAULT NULL, 
createDTM date DEFAULT NULL, 
createUserId varchar(50) DEFAULT NULL, 
lastUpdtDTM date DEFAULT NULL, 
lastUpdtUserId varchar(50) DEFAULT NULL, 
PRIMARY KEY (cusId)); 

-- Create Table Account
CREATE TABLE accountschema.Account ( 
accId int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1),
cusId int DEFAULT NULL, 
CONSTRAINT cusId_fkey
FOREIGN KEY (cusId)
REFERENCES accountschema.Customer(cusId),
accName varchar(200) NOT NULL, 
accBalance varchar(200) NOT NULL, 
status boolean DEFAULT NULL, 
createDTM date DEFAULT NULL, 
createUserId varchar(50) DEFAULT NULL, 
lastUpdtDTM date DEFAULT NULL, 
lastUpdtUserId varchar(50) DEFAULT NULL, 
PRIMARY KEY (accId)); 

-- Create Table AccountFeature
CREATE TABLE accountschema.AccountFeature ( 
accountFeatureId int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1),
accId int NOT NULL, 
CONSTRAINT accId_fkey
FOREIGN KEY (accId)
REFERENCES accountschema.Account(accId),
card varchar(50) DEFAULT NULL, 
cardtype varchar(50) NOT NULL, 
cardlimit varchar(50) NOT NULL, 
createDTM date DEFAULT NULL, 
createUserId varchar(50) DEFAULT NULL, 
lastUpdtDTM date DEFAULT NULL, 
lastUpdtUserId varchar(50) DEFAULT NULL, 
PRIMARY KEY (accountFeatureId)); 
