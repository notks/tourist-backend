-- *************** SqlDBM: PostgreSQL ****************;
-- ***************************************************;

CREATE SCHEMA IF NOT EXISTS "public";


-- ************************************** "Pictures"

CREATE TABLE IF NOT EXISTS "Pictures"
(
 "url"         varchar(100) NOT NULL,
 "location_id" int NOT NULL,
 "Id"          int NOT NULL,
 CONSTRAINT "PK_21" PRIMARY KEY ( "Id" ),
 CONSTRAINT "FK_46" FOREIGN KEY ( "location_id" ) REFERENCES "Locations" ( "id" )
);

CREATE INDEX "fkIdx_48" ON "Pictures"
(
 "location_id"
);







