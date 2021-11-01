-- *************** SqlDBM: PostgreSQL ****************;
-- ***************************************************;

CREATE SCHEMA IF NOT EXISTS "public";


-- ************************************** "Countrys"

CREATE TABLE IF NOT EXISTS "Countrys"
(
 "name" varchar(50) NOT NULL,
 "id"   int NOT NULL,
 CONSTRAINT "PK_33" PRIMARY KEY ( "id" )
);







