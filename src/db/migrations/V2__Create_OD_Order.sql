CREATE TABLE OD_Order (
    Order_ID int NOT NULL PRIMARY KEY,
    Item_Name VARCHAR(50) NOT NULL,
    Options VARCHAR(100),
    Quantity INT NOT NULL ,
    UnitPrice DOUBLE NOT NULL,
    Total DOUBLE NOT NULL
);