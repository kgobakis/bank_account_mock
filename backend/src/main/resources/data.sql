INSERT INTO CUSTOMER
    (id, first_name ,last_name, email)
VALUES
    (1, 'kostas',
        'gobakis', 'k@gmail.com');
INSERT INTO CUSTOMER
    (id, first_name ,last_name, email)
VALUES
    (2, 'Nick',
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
    (id, iban , type, balance)
VALUES
    (1, 'DE 898077890798908',
        0, 20.00);
INSERT INTO ACCOUNT
    (id, iban , type, balance)
VALUES
    (2, 'GR 523127890798908',
        2, 53.00);
INSERT INTO ACCOUNT
    (id, iban , type, balance)
VALUES
    (3, 'DR 96742890798908',
        1, 500.00);
INSERT INTO ACCOUNT
    (id, iban , type, balance)
VALUES
    (4, 'FI 12342890798908',
        1, 870.00);
