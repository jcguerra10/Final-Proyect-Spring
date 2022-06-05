CREATE TABLE productcategory
(
    productcategoryid INTEGER NOT NULL,
    modifieddate      TIMESTAMP WITHOUT TIME ZONE,
    name              VARCHAR(255),
    rowguid           INTEGER,
    CONSTRAINT pk_productcategory PRIMARY KEY (productcategoryid)
);

CREATE TABLE productsubcategory
(
    productsubcategoryid INTEGER NOT NULL,
    modifieddate         TIMESTAMP WITHOUT TIME ZONE,
    name                 VARCHAR(255),
    rowguid              INTEGER,
    productcategoryid    INTEGER,
    CONSTRAINT pk_productsubcategory PRIMARY KEY (productsubcategoryid)
);

ALTER TABLE productsubcategory
    ADD CONSTRAINT FK_PRODUCTSUBCATEGORY_ON_PRODUCTCATEGORYID FOREIGN KEY (productcategoryid) REFERENCES productcategory (productcategoryid);

CREATE TABLE product
(
    productid             INTEGER NOT NULL,
    class                 VARCHAR(255),
    color                 VARCHAR(255),
    daystomanufacture     INTEGER,
    discontinueddate      TIMESTAMP WITHOUT TIME ZONE,
    finishedgoodsflag     VARCHAR(255),
    listprice             DECIMAL,
    makeflag              VARCHAR(255),
    modifieddate          TIMESTAMP WITHOUT TIME ZONE,
    name                  VARCHAR(255),
    productline           VARCHAR(255),
    productnumber         VARCHAR(255),
    reorderpoint          INTEGER,
    rowguid               INTEGER,
    safetystocklevel      INTEGER,
    sellenddate           date,
    sellstartdate         date,
    size                  DECIMAL,
    standardcost          DECIMAL,
    style                 VARCHAR(255),
    weight                DECIMAL,
    productmodelid        INTEGER,
    productsubcategoryid  INTEGER,
    sizeunitmeasurecode   VARCHAR(255),
    weightunitmeasurecode VARCHAR(255),
    CONSTRAINT pk_product PRIMARY KEY (productid)
);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_PRODUCTSUBCATEGORYID FOREIGN KEY (productsubcategoryid) REFERENCES productsubcategory (productsubcategoryid);


CREATE TABLE location
(
    locationid   INTEGER NOT NULL,
    availability DECIMAL,
    costrate     DECIMAL,
    modifieddate TIMESTAMP WITHOUT TIME ZONE,
    name         VARCHAR(255),
    CONSTRAINT pk_location PRIMARY KEY (locationid)
);


CREATE TABLE productcosthistory
(
    id           INTEGER NOT NULL,
    startdate    date,
    enddate      date,
    modifieddate date,
    standardcost DECIMAL,
    productid    INTEGER,
    CONSTRAINT pk_productcosthistory PRIMARY KEY (id)
);

CREATE TABLE productinventory
(
    id                  INTEGER NOT NULL,
    bin                 INTEGER,
    modifieddate        TIMESTAMP WITHOUT TIME ZONE,
    quantity            INTEGER,
    rowguid             INTEGER,
    shelf               VARCHAR(255),
    location_locationid INTEGER,
    product_productid   INTEGER,
    CONSTRAINT pk_productinventory PRIMARY KEY (id)
);

ALTER TABLE productinventory
    ADD CONSTRAINT FK_PRODUCTINVENTORY_ON_LOCATION_LOCATIONID FOREIGN KEY (location_locationid) REFERENCES location (locationid);

ALTER TABLE productinventory
    ADD CONSTRAINT FK_PRODUCTINVENTORY_ON_PRODUCT_PRODUCTID FOREIGN KEY (product_productid) REFERENCES product (productid);


ALTER TABLE productcosthistory
    ADD CONSTRAINT FK_PRODUCTCOSTHISTORY_ON_PRODUCTID FOREIGN KEY (productid) REFERENCES product (productid);


CREATE TABLE user_app
(
    id       BIGINT NOT NULL,
    username VARCHAR(255),
    password VARCHAR(255),
    type     INTEGER,
    CONSTRAINT pk_userapp PRIMARY KEY (id)
);

CREATE TABLE store
(
    id   INTEGER     NOT NULL,
    name VARCHAR(50) NOT NULL,
    CONSTRAINT pk_store PRIMARY KEY (id)
);
CREATE TABLE client
(
    id       INTEGER     NOT NULL,
    store_id INTEGER     NOT NULL,
    name     VARCHAR(50) NOT NULL,
    CONSTRAINT pk_client PRIMARY KEY (id)
);

ALTER TABLE client
    ADD CONSTRAINT FK_CLIENT_ON_STORE FOREIGN KEY (store_id) REFERENCES store (id);


CREATE SEQUENCE STORE_STOREID_SEQUENCE START 1;
CREATE SEQUENCE CLIENT_CLIENTID_SEQUENCE START 1;
CREATE SEQUENCE USER_APP_ID_SEQUENCE START 1;
CREATE SEQUENCE PRODUCT_PRODUCTID_SEQUENCE START 1;
CREATE SEQUENCE PRODUCTCOSTHISTORY_ID_SEQUENCE START 1;
CREATE SEQUENCE PRODUCTINVENTORY_ID_SEQUENCE START 1;
CREATE SEQUENCE PRODUCTCATEGORY_ID_SEQUENCE START 1;
CREATE SEQUENCE PRODUCTSUBCATEGORY_ID_SEQUENCE START 1;
CREATE SEQUENCE LOCATION_ID_SEQUENCE START 1;


