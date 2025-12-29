SHOW DATABASES;
CREATE DATABASE bankSystem;

USE bankSystem;

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    father_name VARCHAR(30),
    gender ENUM('Male','Female','Other'),
    dob DATE NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    marital_status ENUM('Married','Unmarried'),
    address VARCHAR(100),
    city VARCHAR(30),
    pin INT NOT NULL,
    state VARCHAR(30) NOT NULL
);
SELECT * FROM users;
DELETE FROM users;

CREATE TABLE kyc_details (
    user_id INT PRIMARY KEY,
    religion VARCHAR(20),
    category VARCHAR(20),
    income VARCHAR(20),
    education VARCHAR(30),
    occupation VARCHAR(30),
    pan VARCHAR(10) UNIQUE NOT NULL,
    aadhar BIGINT UNIQUE NOT NULL,
    senior_citizen ENUM('Yes','No'),
    existing_account ENUM('Yes','No'),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
        ON DELETE CASCADE
);
SELECT * FROM kyc_details;
DELETE FROM kyc_details;

CREATE TABLE accounts (
    user_id INT PRIMARY KEY,
    account_type VARCHAR(30),
    card_no BIGINT UNIQUE NOT NULL,
    pin INT NOT NULL,
    facilities VARCHAR(200),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
        ON DELETE CASCADE
);
SELECT * FROM accounts;
DELETE FROM accounts;

CREATE TABLE login (
    user_id INT PRIMARY KEY,
    card_no BIGINT UNIQUE NOT NULL,
    pin INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (card_no) REFERENCES accounts(card_no)
);
SELECT * FROM login;
DELETE FROM login;

CREATE TABLE transactions (
    card_no BIGINT,
    txn_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    txn_type ENUM('Deposit','Withdraw','Transfer'),
    amount INT NOT NULL,
    FOREIGN KEY (card_no) REFERENCES accounts(card_no)
);
SELECT * FROM transactions;
DELETE FROM transactions;

SHOW TABLES;

SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE users;
TRUNCATE TABLE kyc_details;
SET FOREIGN_KEY_CHECKS = 1;

SET SQL_SAFE_UPDATES = 0;
DELETE FROM users;
SET SQL_SAFE_UPDATES = 1;

    
	