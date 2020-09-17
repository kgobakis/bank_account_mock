DROP TABLE IF EXISTS Customer;
DROP TABLE IF EXISTS Account;
DROP TABLE IF EXISTS CustomerAccount;
DROP TABLE IF EXISTS AccountType;
DROP TABLE IF EXISTS "Transaction";

CREATE TABLE Customer
(
    id INT NOT NULL
        PRIMARY KEY,
    first_name VARCHAR
    (250) NOT NULL,
    last_name VARCHAR
    (250) NOT NULL,
    street VARCHAR
    (250) DEFAULT NULL,
    city VARCHAR
    (250) DEFAULT NULL,
    state VARCHAR
    (250) DEFAULT NULL,
    zip VARCHAR
    (250) DEFAULT NULL,
    phone VARCHAR
    (250) DEFAULT NULL,
    email VARCHAR
    (250) DEFAULT NULL

);

CREATE TABLE "TRANSACTION"
(
    id INT NOT NULL
        PRIMARY KEY,
    accountID INT NOT NULL,
    timestamp DATE NOT NULL,
    amount DECIMAL
    (6, 2) NOT NULL DEFAULT 0,
    description VARCHAR
    (250) DEFAULT NULL

);

CREATE TABLE AccountType
(
    id INT NOT NULL
        PRIMARY KEY,
    name VARCHAR
    (250) DEFAULT NULL,
    description VARCHAR
    (250) DEFAULT NULL

);
CREATE TABLE Account
(
    id INT NOT NULL
        PRIMARY KEY,
    IBAN VARCHAR
    (250) DEFAULT NULL,
    type INT NOT NULL,
    description VARCHAR
    (250) DEFAULT NULL,
    balance DECIMAL
    (6, 2) NOT NULL DEFAULT 0,
    CONSTRAINT type FOREIGN KEY (type) REFERENCES AccountType(id)

);

CREATE TABLE CustomerAccount
(
    id INT NOT NULL IDENTITY(1, 1) PRIMARY KEY,
    customerID INT NOT NULL,
    accountID INT NOT NULL,
    CONSTRAINT customerID FOREIGN KEY (customerID) REFERENCES Customer
(id),
    CONSTRAINT accountID FOREIGN KEY (accountID) REFERENCES Account
(id)
)

