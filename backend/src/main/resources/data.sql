INSERT INTO CUSTOMER
    (id, accountid, first_name ,last_name, email)
VALUES
    (1, 2, 'kostas',
        'gobakis', 'k@gmail.com');
INSERT INTO CUSTOMER
    (id, accountid, first_name ,last_name, email)
VALUES
    (2, 1, 'Nick',
        'Tokes', 'nick@gmail.com');
-- Adding types
INSERT INTO ACCOUNTTYPE
    (id, name , description)
VALUES
    (0, 'CHECKING',
        ''),
    (1, 'SAVINGS',
        ''),
    (2, 'PRIVATE',
        '');
INSERT INTO ACCOUNT
    (id, customerID, iban , type, balance)
VALUES
    (1, 1, 'DE 898077890798908',
        0, 20.00);
INSERT INTO ACCOUNT
    (id,customerID,iban , type, balance)
VALUES
    (2, 1, 'GR 523127890798908',
        2, 53.00);
INSERT INTO ACCOUNT
    (id, customerID, iban , type, balance)
VALUES
    (3, 1, 'DR 96742890798908',
        1, 500.00);
INSERT INTO ACCOUNT
    (id, customerID,iban , type, balance)
VALUES
    (4, 2, 'FI 12342890798908',
        1, 870.00);
INSERT INTO "TRANSACTION"
    (id, accountid , timestamp, amount)
VALUES
    (1, 2,
        '2020-09-08', 20.00);
INSERT INTO "TRANSACTION"
    (id, accountid , timestamp, amount)
VALUES
    (2, 2,
        '2018-10-29', 340.00);
INSERT INTO "TRANSACTION"
    (id, accountid , timestamp, amount)
VALUES
    (3, 2,
        '2017-10-29', 100.00);