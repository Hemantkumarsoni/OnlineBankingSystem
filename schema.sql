SHOW DATABASES;
CREATE DATABASE bankSystem;

USE bankSystem;

CREATE TABLE signup (
	form VARCHAR(10),
    name VARCHAR(30) NOT NULL,
    fname VARCHAR(30),
    gender VARCHAR(10),
    dob VARCHAR(30) NOT NULL,
    email VARCHAR(30) UNIQUE NOT NULL,
    marital VARCHAR(10) NOT NULL,
    address VARCHAR(30),
    city VARCHAR(30),
    pin INT NOT NULL,
    state VARCHAR(30) NOT NULL
);
SELECT * FROM signup;

CREATE TABLE signup2 (
	form VARCHAR(10),
    religion VARCHAR(30),
    category VARCHAR(30),
    income VARCHAR(30),
    educational VARCHAR(30),
    occupation VARCHAR(30),
    pan VARCHAR(10) UNIQUE NOT NULL,
    aadhar BIGINT UNIQUE NOT NULL,
    seniorCitizen VARCHAR(10),
    existingAccount VARCHAR(10)
);
SELECT * FROM signup2;

CREATE TABLE signup3 (
	form VARCHAR(10),
    accountType VARCHAR(30),
    card_no BIGINT PRIMARY KEY,
    pin INT,
    facility VARCHAR(300)
);
SELECT * FROM signup3;

CREATE TABLE login (
	form VARCHAR(10),
    card_no BIGINT PRIMARY KEY,
    pin INT
);
SELECT * FROM login;

CREATE TABLE bank (
    card_no BIGINT,
    date VARCHAR(30),
    type VARCHAR(30),
    amount INT
);
SELECT * FROM bank;

SHOW TABLES;
    
	