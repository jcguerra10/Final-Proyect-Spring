BEGIN;


CREATE TABLE IF NOT EXISTS public.client
(
    id integer NOT NULL,
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    store_id integer NOT NULL,
    CONSTRAINT client_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.location
(
    locationid integer NOT NULL,
    availability numeric(19, 2),
    costrate numeric(19, 2),
    modifieddate timestamp without time zone,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT location_pkey PRIMARY KEY (locationid)
);

CREATE TABLE IF NOT EXISTS public.product
(
    productid integer NOT NULL,
    class character varying(255) COLLATE pg_catalog."default",
    color character varying(255) COLLATE pg_catalog."default",
    daystomanufacture integer,
    discontinueddate timestamp without time zone,
    finishedgoodsflag character varying(255) COLLATE pg_catalog."default",
    listprice numeric,
    makeflag character varying(255) COLLATE pg_catalog."default",
    modifieddate timestamp without time zone,
    name character varying(255) COLLATE pg_catalog."default",
    productline character varying(255) COLLATE pg_catalog."default",
    productnumber character varying(255) COLLATE pg_catalog."default",
    reorderpoint integer,
    rowguid integer,
    safetystocklevel integer,
    sellenddate date,
    sellstartdate date,
    size numeric,
    standardcost numeric,
    style character varying(255) COLLATE pg_catalog."default",
    weight numeric,
    productmodelid integer,
    productsubcategoryid integer,
    CONSTRAINT pk_product PRIMARY KEY (productid)
);

CREATE TABLE IF NOT EXISTS public.productcategory
(
    productcategoryid integer NOT NULL,
    modifieddate timestamp without time zone,
    name character varying(255) COLLATE pg_catalog."default",
    rowguid integer,
    CONSTRAINT productcategory_pkey PRIMARY KEY (productcategoryid)
);

CREATE TABLE IF NOT EXISTS public.productcosthistory
(
    id integer NOT NULL,
    enddate date,
    modifieddate date,
    standardcost numeric(19, 2),
    startdate date,
    productid integer,
    CONSTRAINT productcosthistory_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.productinventory
(
    id integer NOT NULL,
    bin integer,
    modifieddate timestamp without time zone,
    quantity integer NOT NULL,
    rowguid integer,
    shelf character varying(255) COLLATE pg_catalog."default",
    location_locationid integer,
    product_productid integer,
    CONSTRAINT productinventory_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.productmodel
(
    productmodelid integer NOT NULL,
    catalogdescription character varying(255) COLLATE pg_catalog."default",
    instructions character varying(255) COLLATE pg_catalog."default",
    modifieddate timestamp without time zone,
    name character varying(255) COLLATE pg_catalog."default",
    rowguid integer,
    CONSTRAINT productmodel_pkey PRIMARY KEY (productmodelid)
);

CREATE TABLE IF NOT EXISTS public.productsubcategory
(
    productsubcategoryid integer NOT NULL,
    modifieddate timestamp without time zone,
    name character varying(255) COLLATE pg_catalog."default",
    rowguid integer,
    productcategoryid integer,
    CONSTRAINT productsubcategory_pkey PRIMARY KEY (productsubcategoryid)
);

CREATE TABLE IF NOT EXISTS public.store
(
    id integer NOT NULL,
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT store_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.user_app
(
    id bigint NOT NULL,
    password character varying(255) COLLATE pg_catalog."default",
    type integer NOT NULL,
    username character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT user_app_pkey PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.client
    ADD CONSTRAINT fkq6yj93l5cgrp7s6gdfq5h8p7h FOREIGN KEY (store_id)
    REFERENCES public.store (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.product
    ADD CONSTRAINT fk_product_on_productmodelid FOREIGN KEY (productmodelid)
    REFERENCES public.productmodel (productmodelid) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.product
    ADD CONSTRAINT fk_product_on_productsubcategoryid FOREIGN KEY (productsubcategoryid)
    REFERENCES public.productsubcategory (productsubcategoryid) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.productinventory
    ADD CONSTRAINT fkd3hdykmgunkfvlfh56o6ohttr FOREIGN KEY (location_locationid)
    REFERENCES public.location (locationid) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.productsubcategory
    ADD CONSTRAINT fk8oy5ve0xiyxsej61q8tp48kkk FOREIGN KEY (productcategoryid)
    REFERENCES public.productcategory (productcategoryid) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


CREATE SEQUENCE STORE_STOREID_SEQUENCE START 1;
CREATE SEQUENCE CLIENT_CLIENTID_SEQUENCE START 1;
CREATE SEQUENCE USER_APP_ID_SEQUENCE START 1;
CREATE SEQUENCE PRODUCT_PRODUCTID_SEQUENCE START 1;
CREATE SEQUENCE PRODUCTCOSTHISTORY_ID_SEQUENCE START 1;
CREATE SEQUENCE PRODUCTINVENTORY_ID_SEQUENCE START 1;
CREATE SEQUENCE PRODUCTCATEGORY_ID_SEQUENCE START 1;
CREATE SEQUENCE PRODUCTSUBCATEGORY_ID_SEQUENCE START 1;
CREATE SEQUENCE LOCATION_ID_SEQUENCE START 1;


END;